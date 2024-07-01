package com.springboot.joblisting.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectLogging {

	private static final Logger log = LoggerFactory.getLogger(AspectLogging.class);
	
	@Before("execution(public * com.springboot.joblisting.controller.PostController.getAllPosts())")
	public void log()
	{
		log.info("get posts method called");
	}
	
	//executes if an exception is thrown
	@After("execution(public * com.springboot.joblisting.controller.PostController.getAllPosts())")
	public void logAfter()
	{
		log.info("get posts method called");
	}
	
	//executes only if the method is successful
	@AfterReturning("execution(public * com.springboot.joblisting.controller.PostController.getAllPosts())")
	public void logAfterReturning()
	{
		log.info("method is succesful");
	}
	
	//executes only if the method ran into some issue
	@AfterThrowing("execution(public * com.springboot.joblisting.controller.PostController.getAllPosts())")
	public void logAfterThrowing()
	{
		log.info("issue");
	}
}
