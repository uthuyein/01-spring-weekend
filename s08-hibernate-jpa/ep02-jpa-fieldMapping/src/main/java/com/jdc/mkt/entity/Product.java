package com.jdc.mkt.entity;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( generator = "seq_product_gen" )
	@TableGenerator(name = "seq_product_gen", allocationSize = 1, initialValue = 1)
	private Integer id;
	@Column(name = "product_name",length = 45,nullable = false,unique = true)
	private String name;
	@Column(columnDefinition = "integer not null default 0")
	private Integer price;
	@Transient
	private boolean isActive;
	@Temporal(DATE)
	private Date createDate;
	@Temporal(TemporalType.DATE)
	private Calendar cal;
	private LocalDate modifiedDate;
	
	@Enumerated(STRING)
	@Column(columnDefinition = "enum('SMALL','MEDIUM','LARGE') ")
	private Size size;
	
	public enum Size{
		SMALL,MEDIUM,LARGE;
	}
}
