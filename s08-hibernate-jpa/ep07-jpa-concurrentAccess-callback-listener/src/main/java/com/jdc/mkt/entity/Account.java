package com.jdc.mkt.entity;

import com.jdc.mkt.entity.listener.EnableTimeListener;
import com.jdc.mkt.entity.listener.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.ExcludeDefaultListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
//@EntityListeners(EntityListener.class)
@ExcludeDefaultListeners
public class Account implements EnableTimeListener{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double saving;
	private Time time;
	
//	@PrePersist
//	void preCreate() {
//		System.out.println("Before Create Account");
//	}
//	@PostPersist
//	void afterCreate() {
//		System.out.println("After Create Account");
//	}
//	@PreUpdate
//	void preUpdate() {
//		System.out.println("Before Update Account");
//	}
//	@PostUpdate
//	void afterUpdate() {
//		System.out.println("After Update Accont");
//	}
}
