package com.springboot.joblisting.respository;

import java.util.List;


import com.springboot.joblisting.model.Post;


public interface SearchRepository {
	public List<Post> serchByText(String text);
}
