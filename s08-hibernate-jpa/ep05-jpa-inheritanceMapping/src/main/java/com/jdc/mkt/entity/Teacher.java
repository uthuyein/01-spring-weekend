package com.jdc.mkt.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name = "teacher_tbl")
@DiscriminatorValue("T")
public class Teacher extends Account{
	private static final long serialVersionUID = 1L;

	private String teaching;
	
	public Teacher() {
		super(Role.TEACHER);		
	}

	
}
