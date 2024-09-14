package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "doctor_tbl")
@NamedQueries({
	@NamedQuery(name = "doctor.updateSpecialization",query = "update Doctor  set specialization = :special"),
	@NamedQuery(name = "doctor.updateDepartment",query = "update Doctor d set d.contact.phone = :after where d.contact.phone = :before")
})
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String specialization;
	private Contact contact;
	@ManyToOne
	private Department department;
}
