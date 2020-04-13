package com.blog.aspect;

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
import java.util.Arrays;


@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.blog.controller.*.*(..))")
    public void log(){};

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servlet = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servlet.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        ResultLog resultLog = new ResultLog(url,ip,classMethod,args);
        logger.info("Request : {}",resultLog);
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result : {}",result);
    }

    private class ResultLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] object;

        public ResultLog(String url, String ip, String classMethod, Object[] object) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.object = object;
        }

        @Override
        public String toString() {
            return "ResultLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", object=" + Arrays.toString(object) +
                    '}';
        }
    }
}
