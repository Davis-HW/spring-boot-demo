/**
 * 
 */
package com.davis.test.controller;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author huangwei
 *
 */
@Aspect
@Component
public class LoggerUtil {
	private static  Logger logger = Logger.getLogger(LoggerUtil.class);
	
	@Pointcut("execution(* com.davis.test.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void  controllerMethodPointCut(){}
	
	@Around("controllerMethodPointCut()")
	public Object loggerPrint(ProceedingJoinPoint j){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
		MethodSignature signature = (MethodSignature) j.getSignature();  
	    Method method = signature.getMethod(); //获取被拦截的方法  
	    String methodName = method.getName(); //获取被拦截的方法名  
		Object result = null;
		System.out.println("调用的方法名称为："+methodName+"执行时间为:"+format.format(date));
		logger.error("调用的方法名称为："+methodName+"执行时间为:"+format.format(date));
		try {
			result = j.proceed();
		} catch (Throwable e) {
			logger.error("拦截器执行异常！");
		}
		return result;
	}

}
