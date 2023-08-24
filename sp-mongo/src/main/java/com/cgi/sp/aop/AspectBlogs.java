package com.cgi.sp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectBlogs {
	
	@Before("execution(* com.cgi.sp.services.BlogService.get(int)) && args(x) " )
	public void validateId(int x) {
		System.out.println("Indside AOP before method "+ x);
	}

	

	@Before("execution(* com.cgi.sp.services.BlogService.*(..))")
	public void validateId1() {
		System.out.println("Indside AOP before method 1");
	}
	
	
	
}
