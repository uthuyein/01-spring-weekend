package com.jdc.mkt.transaction.model;

public record SaleResult(int id,Status status,String message) {

	public enum Status{
		INITIATED,SUCCESS,ERROR;
	}
}
