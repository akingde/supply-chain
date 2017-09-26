package com.bubi.creator.service;

public class CreateFactory{
	
	public static CreateDatabaseService getCreateDatabaseInstance() {
		return new CreateDatabaseService();
	}
	
	public static CreateClassService getCreaterClassInstance() {
		return new CreateClassService();
	}
}