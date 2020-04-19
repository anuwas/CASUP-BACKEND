/**
 * 
 */
package com.ca.reportsapp.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author Anupam Biswas
 * 2020-01-30 00:41:52.751
 */
@Aspect
@Component
public class LoggingAspect {
	private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
	
	@Around("execution(* com.ca.reportsapp.controller.*.*(..)) || execution(* com.ca.reportsapp.service.*.*(..))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
          
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
       
        Object result = proceedingJoinPoint.proceed();
  
        LOGGER.info("Executing.. " + className + "." + methodName );
  
        return result;
    }
}
