package com.ssdgroupc.app.security.response;

/**
 * Date: May 26-2020 MessageResponse entity.
 * 
 * @author aman
 * @version 1.0
 * @category Entity
 */
public class MessageResponse {
	private String message;

	public MessageResponse(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
