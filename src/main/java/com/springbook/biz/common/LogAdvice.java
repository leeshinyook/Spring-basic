package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect // aspect = Pointcut + Advice
public class LogAdvice {

	
//	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
//	public void getPointcut() {};
	
	@Before("PointcutCommon.allPointcut()")
	public void printLog() {
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작.");
	}
}
