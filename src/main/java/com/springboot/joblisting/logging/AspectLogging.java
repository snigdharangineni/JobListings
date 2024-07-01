package com.springboot.joblisting.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectLogging {

	@Before("execution(public * com.springboot.joblisting.controller.PostController.getAllPosts())")
	public void log()
	{
		System.out.println("get posts method called");
	}
}
