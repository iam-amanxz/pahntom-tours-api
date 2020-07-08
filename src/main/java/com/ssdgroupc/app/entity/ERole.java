package com.ssdgroupc.app.entity;

public enum ERole {
	ROLE_USER,
    ROLE_MODERATOR,
    ROLE_ADMIN;

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return this.name();
	}
}
