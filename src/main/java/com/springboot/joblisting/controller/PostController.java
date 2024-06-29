package com.springboot.joblisting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.joblisting.PostRepository;
import com.springboot.joblisting.model.Post;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class PostController {
	
	
	@Autowired
	PostRepository repo;

	@ApiIgnore
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException
	{
		response.sendRedirect("/swagger-ui.html");
	}
	
	@GetMapping("/posts")
	public List<Post> getAllPosts()
	{
		return repo.findAll();
	}
	
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post)
	{
		return repo.save(post);
		
	}
}
