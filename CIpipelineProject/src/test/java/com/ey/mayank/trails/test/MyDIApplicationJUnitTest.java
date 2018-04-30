package com.ey.mayank.trails.test;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ey.mayank.trails.consumer.Consumer;
import com.ey.mayank.trails.consumer.MyDIApplication;
import com.ey.mayank.trails.injector.EmailServiceInjector;
import com.ey.mayank.trails.injector.MessageServiceInjector;
import com.ey.mayank.trails.service.MessageService;

public class MyDIApplicationJUnitTest {

	private MessageServiceInjector injector;
	@Before
	public void setUp(){
		//mock the injector with anonymous class
		injector = new MessageServiceInjector() {

			@Override
			public Consumer getConsumer() {
				//mock the message service
				MyDIApplication app = new MyDIApplication();
				app.setService(new MessageService(){

					@Override
					public boolean sendMessage(String msg, String rec) {
						System.out.println("Mock Message Service implementation");
						return true;
					}
				});
				return app;

			}
		};
	}

	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();		
		consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
	}

	@Test
	public void EmailSendCheck_SendMail_Pass(){
		
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		injector = new EmailServiceInjector();
		app = injector.getConsumer();		
		Assert.assertTrue(app.processMessages("Hi Pankaj", "pankaj@abc.com"));
	}
	
	@Test
	public void EmailSendCheck_ValidateEMail_Fail(){
		
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		injector = new EmailServiceInjector();
		app = injector.getConsumer();		
		Assert.assertFalse(app.processMessages("Hi Pankaj", "pankajabc.com"));
	}
	
	@Test
	public void EmailSendCheck_ExceptionHandled_Pass(){
		
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		injector = new EmailServiceInjector();
		app = injector.getConsumer();		
		Assert.assertFalse(app.processMessages("Hi Pankaj", ""));
	}
	@After
	public void tear(){
		injector = null;
	}
}
