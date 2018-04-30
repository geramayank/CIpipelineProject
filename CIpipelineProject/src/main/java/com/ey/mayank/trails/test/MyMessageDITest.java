package com.ey.mayank.trails.test;

import com.ey.mayank.trails.consumer.Consumer;
import com.ey.mayank.trails.injector.EmailServiceInjector;
import com.ey.mayank.trails.injector.MessageServiceInjector;
import com.ey.mayank.trails.injector.SMSServiceInjector;

public class MyMessageDITest {

	public static void main(String[] args) {
		String msg = "Hi Pankaj";
		String email = "pankaj@abc.com";
		String phone = "4088888888";
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}
}
