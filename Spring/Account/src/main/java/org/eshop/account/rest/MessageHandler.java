package org.eshop.account.rest;

public class MessageHandler {

	
	
	
	public static enum  StatusCode {
		
		OK(200),
		unauthorizedLogin(401),
		userNotFound(404);

		private final int code;

		private StatusCode(int code) {
			this.code = code;
		}
		
		public int build(){
			return this.code;
		}
	}
}
