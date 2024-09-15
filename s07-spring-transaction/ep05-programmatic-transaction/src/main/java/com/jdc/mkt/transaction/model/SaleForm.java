package com.jdc.mkt.transaction.model;

import java.util.List;

public record SaleForm (
		int memberId,
		List<SaleItem> items
		){
}
