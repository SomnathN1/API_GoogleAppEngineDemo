package com.uiobject;

import java.io.Serializable;
import java.util.List;

public class UserList extends ErrorVariables implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private int totalRecord;
	
	public UserList(boolean isError, String errorMessage, int errorCode) {
		super(isError, errorMessage, errorCode);
	}
	
	public UserList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
}
