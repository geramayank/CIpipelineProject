package com.ey.mayank.trails.consumer;

public interface Consumer {

	boolean processMessages(String msg, String rec);
}
