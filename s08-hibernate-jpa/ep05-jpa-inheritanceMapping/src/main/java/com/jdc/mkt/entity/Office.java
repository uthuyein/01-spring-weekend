package com.jdc.mkt.entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name ="office_tbl")
@DiscriminatorValue("O")
public class Office extends Account{
	private static final long serialVersionUID = 1L;
	
	@ElementCollection
	private List<Job> jobs ;
	public Office() {
		super(Role.OFFICE);	
		jobs = Arrays.asList(Job.values());
	}

	public enum Job{
		INSERT,UPDATE,DELETE,CREATE
	}
	
}
