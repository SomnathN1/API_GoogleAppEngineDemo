package com.uiobject;


public class User extends ErrorVariables{
		private String name;
		private String ip;
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(String name) {
			super();
			this.name = name;
		}
		
		public User(boolean isError, String errorMessage, int errorCode) {
			super(isError, errorMessage, errorCode);
		}
		
		public User(String name, String ip) {
			super();
			this.name = name;
			this.ip = ip;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}	
}
