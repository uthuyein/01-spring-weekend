package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class VoucherPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private LocalDate createDate;
	private LocalTime createTime;
}
