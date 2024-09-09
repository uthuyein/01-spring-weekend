package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.beans.MyClient;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class AutowiredTest {

	@Autowired
	private MyClient client;
	@Test
	void test() {
		client.action();
	}
}
