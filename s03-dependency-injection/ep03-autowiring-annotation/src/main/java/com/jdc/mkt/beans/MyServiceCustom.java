package com.jdc.mkt.beans;

import org.springframework.stereotype.Component;

@Component
public class MyServiceCustom implements MyService {

	@Override
	public String getMessage() {
		return "This is my custom service !";
	}

}
