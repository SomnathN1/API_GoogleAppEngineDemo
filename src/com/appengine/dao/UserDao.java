package com.appengine.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.uiobject.User;

public class UserDao {

	private Logger logger = Logger.getLogger(UserDao.class.getSimpleName());
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public User save(User user,String ip) {
		Entity employee = new Entity("User");
		employee.setProperty("name", user.getName());
		employee.setProperty("ip", ip);
		datastore.put(employee);
		logger.log(Level.INFO, "User added successfully");
		return user;
	}
	
	public List<Entity> getUsers(){
		Query query = new Query("User");
		List<Entity> results =
			    datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		
		if (results == null || results.isEmpty()) {
			logger.log(Level.INFO, "No Entity found");
		} else {
			logger.log(Level.INFO, "Entity size : " + results.size() );
		}
		return results;
	}
	
	public List<Entity> getUsersByName(String name){
		Filter nameFilter =
			    new FilterPredicate("name", FilterOperator.EQUAL, name);
		
		Query query = new Query("User").setFilter(nameFilter);
		List<Entity> results =
			    datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		
		if (results == null || results.isEmpty()) {
			logger.log(Level.INFO, "No Entity found");
		} else {
			logger.log(Level.INFO, "Entity size : " + results.size() );
		}		
		return results;
	}
}