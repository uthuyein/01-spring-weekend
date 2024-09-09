package com.jdc.mkt.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name = "student_tbl")
@DiscriminatorValue("S")
public class Student extends Account {
	private static final long serialVersionUID = 1L;

	private String books;
	
	public Student() {
		super(Role.STUDENT);		
	}


}
