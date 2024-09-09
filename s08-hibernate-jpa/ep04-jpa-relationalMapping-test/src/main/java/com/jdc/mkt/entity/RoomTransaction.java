package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "room_transaction_tbl")
public class RoomTransaction implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoomTransactionPk id;
	@ManyToOne
	@JoinColumn(insertable = false,updatable = false)
	private Customer customer;
	@ManyToOne
	@JoinColumn(insertable = false,updatable = false)
	private Room room;
	@ManyToOne
	@JoinColumn(insertable = false,updatable = false)
	private Reservation reservation;
	private Double extraCharge;
	
}
