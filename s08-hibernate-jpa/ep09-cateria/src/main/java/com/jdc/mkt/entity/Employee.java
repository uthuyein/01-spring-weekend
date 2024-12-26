package com.jdc.mkt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_tbl")
public class Employee {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	@Column( nullable = false)
	private String name;
	@ManyToOne
	private Department department;
}
