package com.example.springbootdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/7
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    /**
     * 定义切点
     */
    private final static String EXPRESSION = "execution(public * com.example.springbootdemo.web.UserController.*(..))";

    @Pointcut()
    public void excudeService() {
    }

    @Before(EXPRESSION)
    public Object before() throws Throwable {
        log.info("前置通知");
        return null;
    }

    @After(EXPRESSION)
    public Object after() throws Throwable {
        log.info("后置通知");
        return null;
    }

    @Around(EXPRESSION)
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("环绕通知的前置通知");
        Object returnValue = joinPoint.proceed();
        log.info("环绕通知的后置通知");
        return returnValue;
    }

    @AfterThrowing(value = EXPRESSION,throwing = "ex")
    public void throwAdvice(JoinPoint joinPoint, Exception ex) throws Throwable {
        log.info("【Aspect 异常通知】开始执行");
        log.info("出现异常" + ex.getMessage());
        log.info("【Aspect 异常通知】完成执行");
    }
}
