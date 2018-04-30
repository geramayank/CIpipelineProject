package com.ey.mayank.trails.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.validation.ValidationException;

public class EmailServiceImpl implements MessageService {
	@Override
	public boolean sendMessage(String msg, String rec) {
		if ( isValidEmailAddress(rec) ){
			//logic to send email
			System.out.println("Email sent to "+rec+ " with Message="+msg);
			return true;
		}
		else
		{
			System.out.println("Invalid Email");
			return false;
		}
		
	}
	
	public static boolean isValidEmailAddress(String email) {
		try{
			Pattern pattern=Pattern.compile("^([\\w]((\\.(?!\\.))|[-!#\\$%'\\*\\+/=\\?\\^`\\{\\}\\|~\\w])*)(?<=[\\w])@(([\\w][-\\w]*[\\w]\\.)+[a-zA-Z]{2,6})$", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();	
		}catch(ValidationException e){
			System.out.println("Exceptions - " + e);
			return false;
		}
		catch(PatternSyntaxException e){
			System.out.println("Exceptions - " + e);
			return false;
		}
		catch(Exception e){
			System.out.println("Exceptions - " + e);
			return false;
		}
		
		
		}
}
