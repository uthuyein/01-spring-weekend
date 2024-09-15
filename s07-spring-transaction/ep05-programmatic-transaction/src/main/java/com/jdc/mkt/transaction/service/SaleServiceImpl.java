package com.jdc.mkt.transaction.service;

import org.springframework.stereotype.Service;

import com.jdc.mkt.transaction.exception.BussinessException;
import com.jdc.mkt.transaction.model.SaleForm;
import com.jdc.mkt.transaction.model.SaleResult;
import com.jdc.mkt.transaction.repo.MemberRepo;
import com.jdc.mkt.transaction.repo.ProductRepo;
import com.jdc.mkt.transaction.repo.SaleHistoryRepo;
import com.jdc.mkt.transaction.repo.SaleItemRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class SaleServiceImpl implements SaleService{
	
	private final MemberRepo memberRepo;
	private final ProductRepo productRepo;
	private final SaleHistoryRepo saleHistoryRepo;
	private final SaleItemRepo saleItemRepo;

	@Override
	public SaleResult checkout(SaleForm form) {
		validate(form);
		
		var id =  saleHistoryRepo.save(form.memberId());
		
		for(var item:form.items()) {
			
			
		}
		return null;
	}

	private void validate(SaleForm form) {
		if(null == form) {
			throw new BussinessException("Sale form must not be null");
		}
		
		if(memberRepo.coundById(form.memberId()) == 0) {
			throw new BussinessException("Invalid member id.");
		}
		
		if(null == form.items() || form.items().isEmpty()) {
			throw new BussinessException("Please select items.");
		}
		
		
	}

}
