package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class RoomTransactionPk implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "room_id")
	private Integer roomId;
	@Column(name = "reservation_id")
	private Integer reservationId;
}
