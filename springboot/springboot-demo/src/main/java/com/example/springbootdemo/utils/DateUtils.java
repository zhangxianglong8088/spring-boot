package com.example.springbootdemo.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * @author czc
 * @Date 2022/04/21
 * @Version 1.0
 */
public class DateUtils {
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
	public static final String YYYY_MM_DD_CH = "yyyy年MM月dd日";
	public static final String YYYYMMDD = "yyyyMMdd";

	private DateUtils() {

	}

	/**
	 * String转换成LocalDate
	 *
	 * @return
	 */
	public static LocalDate parseLocalDate(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(YYYY_MM_DD));
	}

	public static String format(LocalDate date, String pattern) {
		if (date == null) {
			return StringUtils.EMPTY;
		}

		return date.format(DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE));
	}

	public static String format(LocalDateTime dateTime, String pattern) {
		if (dateTime == null) {
			return StringUtils.EMPTY;
		}

		return dateTime.format(DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE));
	}

	public static String localDateTimeToString(LocalDateTime dateTime, String pattern) {
		if (dateTime == null) {
			return StringUtils.EMPTY;
		}
		DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE);
		return df.format(dateTime);
	}

	public static String dateToString(Date date, String format) {
		if (date == null) {
			return null;
		}

		SimpleDateFormat formatter = new SimpleDateFormat(format);

		return formatter.format(date);
	}

	/**
	 * 将date转为localDateTime
	 *
	 * @param date
	 * @return
	 */
	public static LocalDateTime convertDateToLocalDateTime(Date date) {
		if (date == null) {
			return null;
		}
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = date.toInstant().atZone(zoneId).toLocalDateTime();
		return localDateTime;
	}

	public static LocalDate convertDateToLocalDate(Date date) {
		if (date == null) {
			return null;
		}
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDate localDateTime = date.toInstant().atZone(zoneId).toLocalDate();
		return localDateTime;
	}

	/**
	 * String转换成LocalDateTime
	 *
	 * @return
	 */
	public static LocalDateTime parseLocalDateTime(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(YYYY_MM_DD));
		return LocalDateTime.of(localDate, LocalTime.of(0, 0));
	}

	/**
	 * String转换成LocalDateTime
	 *
	 * @return
	 */
	public static LocalDateTime parseLocalDateTimeForFormatStr(String date, String fmt) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(fmt));
		return LocalDateTime.of(localDate, LocalTime.of(0, 0));
	}

	/**
	 * String转换成LocalDateTime 具体到秒
	 *
	 * @return
	 */
	public static LocalDateTime parseDetailLocalDateTime(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		DateTimeFormatter df = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
		return LocalDateTime.parse(date, df);
	}

	/**
	 * 获取前或后X天
	 */
	public static Date getBeforeOrNextDay(int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	/**
	 * 获取一天的开始时间
	 *
	 * @param localDate
	 * @return
	 */
	public static LocalDateTime getDayStartTime(LocalDate localDate) {
		LocalTime localTime = LocalTime.of(0, 0, 0);
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		return localDateTime;
	}

	/**
	 * 获取一天的结束时间
	 *
	 * @param localDate
	 * @return
	 */
	public static LocalDateTime getDayEndTime(LocalDate localDate) {
		LocalTime localTime = LocalTime.of(23, 59, 59);
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		return localDateTime;
	}

	public static Date localDateToDate(LocalDateTime localDateTime){
		return Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
	}


	public static Date parseDateNoTime(String sDate, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

    /**
	 * string 的日期转为LocalDateTime 并取小时
	 * @param sDate
	 * @return
	 */
	public static LocalDateTime parseToLocalDateHour(String sDate) {
		Date date = DateUtils.parseDateNoTime(sDate,DateUtils.YYYY_MM_DD_HH);
		return  DateUtils.convertDateToLocalDateTime(date);
	}
}
