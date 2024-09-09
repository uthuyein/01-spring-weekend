package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "medical_record_tbl")
public class MedicalRecord implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MedicalRecordPk id;
	@ManyToOne
	@MapsId("patientId")
	private Patient patient;
	@ManyToOne
	@MapsId("doctorId")
	private Doctor doctor;
	@ManyToOne
	private Prescription prescription;
	private String diagonosis;
	private String treatment;
	private String note;
}
