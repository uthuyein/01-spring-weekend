package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@IdClass(CustomerPk.class)
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CustomerPk id;
	
//	@Id
//	private String nrc;
//	@Id
//	private String email;
	private String name;
	private int age;
	
	
}
