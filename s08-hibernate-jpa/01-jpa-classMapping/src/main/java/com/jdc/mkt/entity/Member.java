package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Member implements Serializable{

	private static final long serialVersionUID = 1L;
	private String loginId;
	private String password;
	
	
	
	
}
