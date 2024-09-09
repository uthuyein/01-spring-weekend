package com.jdc.mkt.entity;

public enum RoomType {
	SINGLE {
		@Override
		Double getCharge() {
			return charge;
		}
	},DOUBLE {
		@Override
		Double getCharge() {
			return charge*2;
		}
	},MASTER {
		@Override
		Double getCharge() {
			return charge*3;
		}
	};
	
	private static double charge;
	
	abstract Double getCharge();
	
	public void setCharge(Double charge) {
		RoomType.charge = charge;
	}
}
