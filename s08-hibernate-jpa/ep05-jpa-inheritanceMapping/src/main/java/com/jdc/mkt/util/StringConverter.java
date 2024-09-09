package com.jdc.mkt.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringConverter implements AttributeConverter<String, Integer>{

	@Override
	public Integer convertToDatabaseColumn(String str) {
		return Integer.parseInt(str);
	}

	@Override
	public String convertToEntityAttribute(Integer data) {
		return data.toString();
	}

}
