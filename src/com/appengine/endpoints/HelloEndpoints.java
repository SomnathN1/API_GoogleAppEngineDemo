package com.appengine.endpoints;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.appengine.service.UserService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.uiobject.User;
import com.uiobject.UserList;

@Api(name = "helloApi",version = "v1")
public class HelloEndpoints {
	
	public static final UserService userService = new UserService();
	public static final Logger logger = Logger.getLogger(HelloEndpoints.class.getSimpleName());
	
	
	/**
	 * This method save input name to datastore and return same input  
	 * @param name
	 * @param req
	 * @return
	 * @throws UnknownHostException
	 */
	@ApiMethod(name="helloUser",httpMethod=HttpMethod.POST,path="hello")
	public  User helloUser(@Named("name") String name,HttpServletRequest req) throws UnknownHostException{
		try{
			User user = userService.addUser(name,req);
			logger.log(Level.INFO, "User saved successfully");
			return user;
		}catch(Exception e){
			logger.log(Level.SEVERE, e.getMessage(), e);
			User user = new User(true, e.getMessage(), 500);
			return user;
		}
	}
	
	/**
	 * This method is used to list all users
	 * @return
	 */
	@ApiMethod(name="listUsers",httpMethod=HttpMethod.GET,path="users/list")
	public  UserList listUsers() {
		try{
			UserList userList = userService.listUsers();
			logger.log(Level.INFO, "User List size : "+userList.getTotalRecord());
			return userList;
		}catch(Exception e){
			logger.log(Level.SEVERE, e.getMessage(), e);
			UserList userList = new UserList(true, e.getMessage(), 500);
			return userList;
		}
	}
	
	/**
	 * This method will be used to get user list which have exact given name
	 * @param name
	 * @return
	 */
	
	@ApiMethod(name="getUser",httpMethod=HttpMethod.GET,path="users/byname")
	public  UserList getUser(@Named("name") String name) {
		try{
			UserList userList = userService.listUsersByName(name);
			logger.log(Level.INFO, "User List size : "+userList.getTotalRecord());
			return userList;
		}catch(Exception e){
			logger.log(Level.SEVERE, e.getMessage(), e);
			UserList userList = new UserList(true, e.getMessage(), 500);
			return userList;
		}
	}
}