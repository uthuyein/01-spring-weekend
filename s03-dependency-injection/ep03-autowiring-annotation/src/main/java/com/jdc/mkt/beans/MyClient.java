package com.jdc.mkt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyClient {

	private MyService myService;
	
	
	public MyClient(MyService myService) {
		super();
		this.myService = myService;
	}
	@Autowired
	public void setService(MyService myService) {
		this.myService = myService ;
	}
	public String action() {
		return myService.getMessage();
	}
}
