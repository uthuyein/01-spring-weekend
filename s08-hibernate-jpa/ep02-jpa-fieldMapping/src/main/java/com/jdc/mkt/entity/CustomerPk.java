package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CustomerPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nrc;
	private String email;
	
// 	can use collection type in embeddable type 
//	when embeddable type is not in other entity collection type and embeddedId.
//	@ElementCollection
//	private List<String> datas ;
}
