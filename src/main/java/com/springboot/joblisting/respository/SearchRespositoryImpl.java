package com.springboot.joblisting.respository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.springboot.joblisting.model.Post;

@Repository
public class SearchRespositoryImpl implements SearchRepository{

	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter converter;
	
	@Override
	public List<Post> serchByText(String text) {
		// TODO Auto-generated method stub
		List<Post> posts = new ArrayList<>();
		
		MongoDatabase database = mongoClient.getDatabase("joblisting");
		MongoCollection<Document> collection = database.getCollection("JobPosting");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("text", 
		    new Document("query", text)
		                .append("path", Arrays.asList("techs", "desc", "profile")))), 
		    new Document("$sort", 
		    new Document("exp", 1L)), 
		    new Document("$limit", 5L)));
		
		result.forEach(doc -> posts.add(converter.read(Post.class, doc)));
		
		return posts;
	}

}
