package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class MedicalRecordPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private LocalDate visitDate;
	@Column(name = "patient_id")
	private Integer patientId;
	@Column(name = "doctor_id")
	private Integer doctorId;
}
