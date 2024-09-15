package com.jdc.mkt.transaction.service;

import com.jdc.mkt.transaction.model.SaleForm;
import com.jdc.mkt.transaction.model.SaleResult;

public interface SaleService {

	SaleResult checkout(SaleForm form);
}
