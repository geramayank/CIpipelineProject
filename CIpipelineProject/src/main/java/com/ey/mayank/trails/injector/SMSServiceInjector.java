package com.ey.mayank.trails.injector;

import com.ey.mayank.trails.consumer.Consumer;
import com.ey.mayank.trails.consumer.MyDIApplication;
import com.ey.mayank.trails.service.SMSServiceImpl; 

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		// TODO Auto-generated method stub
		MyDIApplication app = new MyDIApplication();
		app.setService(new SMSServiceImpl());
		return app;
	}

}
