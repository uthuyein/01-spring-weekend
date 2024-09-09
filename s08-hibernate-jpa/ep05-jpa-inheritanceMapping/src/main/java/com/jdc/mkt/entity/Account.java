package com.jdc.mkt.entity;

import java.io.Serializable;

import com.jdc.mkt.util.StringConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import lombok.Data;

@Entity
@Data
//@MappedSuperclass
@Inheritance
@DiscriminatorValue("A")
@DiscriminatorColumn(name = "childClass",discriminatorType = DiscriminatorType.CHAR)
public abstract class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private String loginId;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Convert(converter = StringConverter.class,disableConversion = false)
	private String age;
	
	Account(Role role){
		this.role = role;
	}
	
	public enum Role{
		TEACHER,STUDENT,OFFICE
	}
}

//@MapSuperClass will created table for each child table and that will be used all fields of super class
//@Inheritace with attribute of table-per-class, same as @MapSuperClass and it's can't use identity for id column
//@Inheritace with attribute of single-table ,it's create with DType Column for child class
//DType column ,can use @DiscriminatorColmn for customizing column name and type.
//DiscriminatorType.CHAR, it's must have disriminatorValue on super class.

