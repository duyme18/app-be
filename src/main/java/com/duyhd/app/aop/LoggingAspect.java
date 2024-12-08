package com.duyhd.app.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("controllerMethods()")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        long startTime = System.currentTimeMillis();

        log.info("Starting method: {} with arguments: {}", methodName, args);

        Object result = null;
        try {
            result = joinPoint.proceed();
            log.info("Method {} executed successfully, result: {}", methodName, result);
        } catch (Exception e) {
            log.error("Method {} threw an exception: {}", methodName, e.getMessage(), e);
            throw e;
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            log.info("Method {} executed in {} ms", methodName, executionTime);
        }

        return result;
    }

    @Pointcut("execution(* com.duyhd.app.controller..*(..))")
    public void controllerMethods() {}

    @Pointcut("execution(* com.duyhd.app.service..*(..))")
    public void serviceMethods() {}
}
