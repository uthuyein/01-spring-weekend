package com.jdc.spring.model.dto;

import java.io.Serializable;

public record Division(
		Integer id,
		String name,
		String capital,
		String region) implements Serializable{

}
