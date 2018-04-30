package com.ey.mayank.trails.injector;

import com.ey.mayank.trails.consumer.Consumer;
import com.ey.mayank.trails.consumer.MyDIApplication;
import com.ey.mayank.trails.service.EmailServiceImpl; 

public class EmailServiceInjector implements MessageServiceInjector {
	
	@Override
	public Consumer getConsumer() {
		// TODO Auto-generated method stub
				
		MyDIApplication app = new MyDIApplication();
		app.setService(new EmailServiceImpl());
		return app;
	}

}
