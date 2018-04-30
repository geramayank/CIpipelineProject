package com.ey.mayank.trails.consumer;

import com.ey.mayank.trails.service.MessageService;

public class MyDIApplication implements Consumer {

	private MessageService service;
	
	public MyDIApplication(){}

	//setter dependency injection	
	public void setService(MessageService service) {
		this.service = service;
	}
	
	@Override
	public boolean processMessages(String msg, String rec) {
		// TODO Auto-generated method stub
		//do some msg validation, manipulation logic etc
		return this.service.sendMessage(msg, rec);
	}
}
