package com.jdc.mkt.test;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.ApplicationConfig;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class TestConfig {

}
