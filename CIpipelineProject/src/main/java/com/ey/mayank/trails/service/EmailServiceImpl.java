package com.ey.mayank.trails.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.validation.ValidationException;

import com.ey.mayank.trials.exception.MyBusinessException;

public class EmailServiceImpl implements MessageService {
	@Override
	public boolean sendMessage(String msg, String rec) {
		try {
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
		} catch (MyBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean isValidEmailAddress(String email) throws MyBusinessException{
		String patternString = "^([\\w]((\\.(?!\\.))|[-!#\\$%'\\*\\+/=\\?\\^`\\{\\}\\|~\\w])*)(?<=[\\w])@(([\\w][-\\w]*[\\w]\\.)+[a-zA-Z]{2,6})$";
		try{
			
			Pattern pattern=Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();	
		}catch(ValidationException e){
			System.out.println("Exceptions - " + e);
			return false;
		}
		catch(PatternSyntaxException e){
			System.out.println("Exceptions - " + e);
			throw new MyBusinessException("Incorrect Pattern" + patternString);
			
		}
		catch(Exception e){
			System.out.println("Exceptions - " + e);
			return false;
		}
		
		
		}
}
