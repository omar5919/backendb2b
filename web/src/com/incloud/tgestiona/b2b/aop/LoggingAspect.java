package com.incloud.tgestiona.b2b.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect extends Auditoria {

	@Around("execution(* com.incloud.tgestiona.b2b.servicesImpl.*.*(..))")
	///@Around("execution(* com.incloud.tgestiona.*.*(..))")
	public Object logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		return logExecutionTime(joinPoint, "LogAnotacion");
	}

}
