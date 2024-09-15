package com.jdc.mkt.test.moak;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jdc.mkt.transaction.exception.BussinessException;
import com.jdc.mkt.transaction.model.SaleForm;
import com.jdc.mkt.transaction.model.SaleItem;
import com.jdc.mkt.transaction.repo.MemberRepo;
import com.jdc.mkt.transaction.repo.ProductRepo;
import com.jdc.mkt.transaction.repo.SaleHistoryRepo;
import com.jdc.mkt.transaction.repo.SaleItemRepo;
import com.jdc.mkt.transaction.service.SaleServiceImpl;

@ExtendWith(value = MockitoExtension.class)
public class SaleServiceUnitTest {

	@Mock private MemberRepo memberRepo;
	@Mock private ProductRepo productRepo;
	@Mock private SaleHistoryRepo saleHistoryRepo;
	@Mock private SaleItemRepo saleItemRepo;
	
	@InjectMocks
	private SaleServiceImpl service;
	
	@Order(1)
	@ParameterizedTest
	@NullSource
	void test_null_form(SaleForm fomr) {
		
		var ex = assertThrows(BussinessException.class, () ->service.checkout(fomr));
		
		assertThat(ex)
		.hasFieldOrPropertyWithValue("message", "Sale form not be null");
	}
	
	@Order(2)
	@ParameterizedTest
	@MethodSource
	void test_invalid_member_id(SaleForm form) {
		when(memberRepo.coundById(form.memberId()))
		.thenReturn(0);
		
		var ex = assertThrows(BussinessException.class, () -> service.checkout(form));
		assertThat(ex)
		.hasFieldOrPropertyWithValue("message", "Invalid member id .");
		
	}
	
	static List<SaleForm> test_invalid_member_id() {
		return List.of(new SaleForm(1, List.of()));
	}
	
	@Order(3)
	@ParameterizedTest
	@MethodSource
	void test_empty_items(SaleForm form) {
		when(memberRepo.coundById(form.memberId()))
		.thenReturn(1);
	}
	
	static List<SaleForm> test_empty_items(){
		return List.of(new SaleForm(1,List.of()),new SaleForm(1, null));
	}
	
	@Order(4)
	@ParameterizedTest
	@MethodSource
	void test_invalid_product_id(SaleForm form) {
		when(memberRepo.coundById(form.memberId()))
		.thenReturn(1);
		
		for(var item:form.items()) {
			when(memberRepo.coundById(item.productId()))
			.thenReturn(1);
		}
		var ex = assertThrows(BussinessException.class, () -> service.checkout(form));
		assertThat(ex)
		.hasFieldOrPropertyWithValue("message", "Invalid member id .");
	}
	
	static List<SaleForm> test_invalid_product_id() {
		return List.of(new SaleForm(1, List.of(
				new SaleItem(1,0)
				)));
	}
}
