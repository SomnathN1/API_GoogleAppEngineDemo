package com.appengine.service;


import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.appengine.dao.UserDao;
import com.google.appengine.api.datastore.Entity;
import com.uiobject.User;
import com.uiobject.UserList;

public class UserService {
	UserDao userDao = new UserDao();
	private Logger logger = Logger.getLogger(UserDao.class.getSimpleName());
	public User addUser(String name,HttpServletRequest req) throws UnknownHostException{
		User user = new User(name);
		String ip = getIP(req);
		
		userDao.save(user,ip);
		return user;
	}
	
	public UserList listUsers(){
		UserList userList = new UserList();
		
		List<Entity> entities = userDao.getUsers();
		if(entities == null || entities.isEmpty()){
			return userList;
		}
		
		List<User> users = iterateUserEntities(entities);
		
		userList.setUsers(users);
		userList.setTotalRecord(users.size());
		return userList;
	}
	
	public UserList listUsersByName(String name){
		UserList userList = new UserList();
		List<Entity> entities = userDao.getUsers();
		if(entities == null || entities.isEmpty()){
			return userList;
		}
		
		List<User> users = iterateUserEntities(entities);
			
		userList.setUsers(users);
		userList.setTotalRecord(users.size());
		return userList;
	}
	
	
	private List<User> iterateUserEntities(List<Entity> entities){
		List<User> users = new ArrayList<>();
		for (Entity entity : entities) {
			 String name = (String) entity.getProperty("name");
			 String ip = (String) entity.getProperty("ip");
			 User user  = new User(name, ip);
			 users.add(user);
		}
		return users;
	}
	
	
	private String getIP(HttpServletRequest req) throws UnknownHostException{
		String userIp = req.getRemoteAddr();
		  logger.info("userIP is: "+userIp);
	      final InetAddress address = InetAddress.getByName(userIp);
	      if (address instanceof Inet6Address) {
	        // nest indexOf calls to find the second occurrence of a character in a string
	        // an alternative is to use Apache Commons Lang: StringUtils.ordinalIndexOf()
	        userIp = userIp.substring(0, userIp.indexOf(":", userIp.indexOf(":") + 1)) + ":*:*:*:*:*:*";
	      } else if (address instanceof Inet4Address) {
	        userIp = userIp.substring(0, userIp.indexOf(".", userIp.indexOf(".") + 1)) + ".*.*";
	      }
	      return userIp;
	}
}
