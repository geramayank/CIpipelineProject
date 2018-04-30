package com.ey.mayank.trails.service;

public class SMSServiceImpl implements MessageService {

	@Override
	public boolean sendMessage(String msg, String rec) {
		// TODO Auto-generated method stub
		//logic to send SMS
		System.out.println("SMS sent to "+rec+ " with Message="+msg);
		return true;
	}

}
