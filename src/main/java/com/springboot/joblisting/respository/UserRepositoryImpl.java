package com.springboot.joblisting.respository;

import java.util.Arrays;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.springboot.joblisting.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter converter;
	
	@Override
	public User findByUserName(String userName) {
		
		MongoDatabase database = mongoClient.getDatabase("joblisting");
		MongoCollection<Document> collection = database.getCollection("User");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("text", 
		    new Document("query", userName)
		                .append("path", "username")))));
		return converter.read(User.class, result.first());
	}

}
