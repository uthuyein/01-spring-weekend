package com.jdc.mkt.entity;

import com.jdc.mkt.entity.listener.EnableTimeListener;
import com.jdc.mkt.entity.listener.Time;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
//@EntityListeners(EntityListener.class)
public class Member implements EnableTimeListener{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,length = 45)
	private String name;
	@Column(nullable = false,length = 20,unique = true)
	private String loginId;
	@Column(nullable = false,length = 20)
	private String password;
	//@Column(columnDefinition = "varchar(20) not null check('email' like '%@%')")
	private String email;
	private Time time;
}
