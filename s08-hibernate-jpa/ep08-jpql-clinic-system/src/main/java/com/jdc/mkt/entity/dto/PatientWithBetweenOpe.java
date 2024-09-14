package com.jdc.mkt.entity.dto;

import java.time.LocalDate;

import com.jdc.mkt.entity.Patient.Gender;

public record PatientWithBetweenOpe(
			String name,
			LocalDate date,
			Gender gender,
			String phone) {

}
