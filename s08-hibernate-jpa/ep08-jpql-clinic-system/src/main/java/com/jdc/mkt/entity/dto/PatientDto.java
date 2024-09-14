package com.jdc.mkt.entity.dto;

import java.time.LocalDate;

import com.jdc.mkt.entity.Patient.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDto{
	private	String name;
	private	LocalDate dob;
	private	Gender gender;
		
		public PatientDto(String name, LocalDate dob, Gender gender) {
			super();
			this.name = name;
			this.dob = dob;
			this.gender = gender;
		}
		
		

}
