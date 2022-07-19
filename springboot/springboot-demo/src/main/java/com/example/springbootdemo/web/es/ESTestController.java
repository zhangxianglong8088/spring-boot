package com.example.springbootdemo.web.es;

import com.example.springbootdemo.service.es.ESService;
import com.example.springbootdemo.service.es.domain.User;
import com.example.springbootdemo.service.es.repository.UserRepository;
import com.example.springbootdemo.service.kill.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/2/10
 */
@RestController
@Slf4j
public class ESTestController {

    @Resource
    private ESService esService;

    @Resource
    private UserRepository userRepository;

    /**
     * 创建doc
     *
     * @throws InterruptedException
     * @throws KeeperException
     * @throws IOException
     */
    @GetMapping("/es/save")
    @ApiOperation(value = "ES学习", notes = "")
    public void save() throws InterruptedException, KeeperException, IOException {
        // 模拟新增的User
        User user = new User();
        user.setId("2");
        user.setUsername("里斯");
        user.setAge(20);
        user.setBirth(new Date());
        user.setIntro("我是里斯");

        try {
            userRepository.save(user);
        } catch (Exception e) {
            /**
             * 原因是因为es服务器的响应程序解析不了，有可能是spring-boot版本低了，没有做这方面的处理，我的es是8.0版本的，但是数据是能保存进es的，
             * 而且es那边也不报错，所以我干脆在添加的方法上做个try{}catch(){},捕捉异常处理，代码如下：
             */
            log.error("save报错。。。");
        }
    }


    /**
     * 删除doc
     *
     * @throws InterruptedException
     * @throws KeeperException
     * @throws IOException
     */
    @GetMapping("/es/delete/{id}")
    @ApiOperation(value = "ES学习", notes = "")
    public void delete(@PathVariable("id") Integer id) throws InterruptedException, KeeperException, IOException {
        try {
            userRepository.deleteById(String.valueOf(id));
        } catch (Exception e) {
            log.error("delete报错。。。");
        }
    }


    /**
     * 更新doc
     *
     * @throws InterruptedException
     * @throws KeeperException
     * @throws IOException
     */
    @GetMapping("/es/update")
    @ApiOperation(value = "ES学习", notes = "")
    public void update() throws InterruptedException, KeeperException, IOException {
        try {
            // 模拟已经更新username后的User
            User user = new User();
            user.setId("2");
            user.setUsername("小明");
            user.setAge(18);
            user.setBirth(new Date());
            user.setIntro("我是小明");

            userRepository.save(user);
        } catch (Exception e) {
            log.error("update报错。。。");
        }
    }


    /**
     * 查询
     *
     * @throws InterruptedException
     * @throws KeeperException
     * @throws IOException
     */
    @GetMapping("/es/get/{id}")
    @ApiOperation(value = "ES学习", notes = "")
    public void get(@PathVariable("id") Integer id) throws InterruptedException, KeeperException, IOException {
        try {
            Optional<User> user = userRepository.findById(String.valueOf(id));
            log.info("User ", user.toString());
        } catch (Exception e) {
            log.error("update报错。。。");
        }
    }
}
