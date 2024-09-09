package com.jdc.mkt.beans;

import org.springframework.stereotype.Component;

@Component
public class MyServiceDefault implements MyService {

	@Override
	public String getMessage() {
		return "This is my default service !";
	}

}
