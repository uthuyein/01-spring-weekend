package com.jdc.mkt.dto.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectCategoryDtoClass {

	private int id;
	private String name;
	
	public SelectCategoryDtoClass() {
		super();
	}

	public SelectCategoryDtoClass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	
}
