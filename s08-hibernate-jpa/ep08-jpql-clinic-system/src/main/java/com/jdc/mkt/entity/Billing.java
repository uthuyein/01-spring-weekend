package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "billing_tbl")
public class Billing implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Appointment appointment;
	private double amount;
	private LocalDate billDate;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	public enum PaymentType{
		CASH,KPAY,WAVE,AYAPAY
	}
}
