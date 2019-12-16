package com.db.api.japi.springAop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerLogAspect {
    private static final Logger logger= LoggerFactory.getLogger(ControllerLogAspect.class);//LogFactory.getLog(RequestLogAspect.class);

    //切入点1
    @Pointcut("execution(public * com.db.api.japi.controller.*.*(..))")
    public  void ControllerPointcutLog(){}

    //何时操作
    @Before("ControllerPointcutLog()")
    public void doBeforeLog(JoinPoint joinPoint){
        //接受请求，记录请求信息
//        SerletRequestAttributes
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //记录下请求内容
        logger.info("URL :"+request.getRequestURL().toString());
        logger.info("IP :"+request.getRemoteAddr());
    }


    @AfterReturning(returning = "ret",pointcut = "ControllerPointcutLog()")
    public void doAfterLog(Object ret){
        //处理请求，返回内容
        logger.info("RESPONSE IS : "+ret);
    }



}
