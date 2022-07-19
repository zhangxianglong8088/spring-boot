package com.example.springbootdemo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/3/21
 */
public class SnowflakeIdWorker {
	private final Logger logger = LoggerFactory.getLogger(SnowflakeIdWorker.class);

	private final static Long START_TIME_STAMP = 1561700251409L; // 开始时间戳 2019-06-28 13:37:31

	private final static Long WORK_ID_BIT = 10L; // workid的范围是0~1023

	private final static Long SEQUENCE_BIT = 12L; // 序列号的范围是0~4095

//    private final static Long MAX_WORK_ID_BIT = -1L ^ (-1L << WORK_ID_BIT); // 最大workid 二进制 1111111111

	private final static Long MAX_SEQUENCE_BIT = -1L ^ (-1L << SEQUENCE_BIT);// 最大序列号 二进制 111111111111

	private final static Long WORK_ID_LEFT_SHIFT = SEQUENCE_BIT;// workid左移12位

	private final static Long TIME_STAMP_LEFT_SHIFT = SEQUENCE_BIT + WORK_ID_BIT;// 时间戳左移22位

	private long lastTimeStamp = -1L; // 上一次时间戳
	private long sequence = 0L;// 序列号
	private long workId;// 默认为ip

	public SnowflakeIdWorker() {
		workId = getIpForWorkId();

	}

	/**
	 * @return
	 * @Description 获取分布式id
	 * @Author Xue Yaowei
	 * @Date 2018年6月12日 下午12:57:14
	 */
	public synchronized Long nextId() {

		Long currentTimeStamp = getCurrentTimeStamp();
		if (currentTimeStamp < lastTimeStamp) {
			// 当前时间戳小于上次时间戳，发生了时间回拨
			long offset = lastTimeStamp - currentTimeStamp;
			if (offset < 5) {
				try {
					wait(offset << 1);// 等待2倍时间
					currentTimeStamp = getCurrentTimeStamp();
					if (currentTimeStamp < lastTimeStamp) {
						// 还是小于，抛异常
						throw new RuntimeException("发生时间回拨,拒绝生成id");
					}
				} catch (InterruptedException e) {
					logger.error("获取当前时间戳出错", e);
					Thread.currentThread().interrupt();
				}

			} else {
				throw new RuntimeException("时间回拨大于5ms,拒绝生成id");
			}
		}

		if (currentTimeStamp == lastTimeStamp) {
			// 相同毫秒内，序列号自增
			sequence = (sequence + 1) & MAX_SEQUENCE_BIT;
			if (sequence == 0L) {
				// 相同毫秒内，序列号到大最大值
				currentTimeStamp = getNextMillisecond(lastTimeStamp);// 当前时间戳移到下一毫秒
			}
		}

		if (currentTimeStamp > lastTimeStamp) {
			// 当前时间戳大于上次时间戳
			sequence = 0L;
		}

		lastTimeStamp = currentTimeStamp;

		return ((currentTimeStamp - START_TIME_STAMP) << TIME_STAMP_LEFT_SHIFT) // 时间戳左移22位
			| (workId << WORK_ID_LEFT_SHIFT) // workId左移12位
			| sequence; // 序列号
	}

	/**
	 * @return
	 * @Description 获取下一毫秒时间戳
	 * @Author Xue Yaowei
	 * @Date 2018年6月12日 下午4:08:11
	 */
	private long getNextMillisecond(Long lastTimeStamp) {

		long currentTimeStamp = getCurrentTimeStamp();
		while (currentTimeStamp <= lastTimeStamp) {
			currentTimeStamp = getCurrentTimeStamp();
		}
		return currentTimeStamp;
	}

	/**
	 * @return
	 * @Description 获取当前时间戳
	 * @Author Xue Yaowei
	 * @Date 2018年6月12日 下午3:34:32
	 */
	private Long getCurrentTimeStamp() {
		return System.currentTimeMillis();
	}

	/**
	 * @return
	 * @Description 把IP当做workid(只计算最后一个网段 ， 小于1023)
	 * @Author Xue Yaowei
	 * @Date 2018年6月12日 下午4:22:32
	 */
	// 有风险，如10.33.80.132 10.33.79.132 会生成相同的workId
	private Long getIpForWorkId() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			byte[] ipAddr = addr.getAddress();
			StringBuilder ipAddrBuffer = new StringBuilder();
			ipAddrBuffer.append(ipAddr[3] & 0xFF);
			return Long.valueOf(ipAddrBuffer.toString()) & (~(-1 << 10));
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

}
