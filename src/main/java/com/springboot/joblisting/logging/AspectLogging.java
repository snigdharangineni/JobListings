package com.springboot.joblisting.logging;

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
}
