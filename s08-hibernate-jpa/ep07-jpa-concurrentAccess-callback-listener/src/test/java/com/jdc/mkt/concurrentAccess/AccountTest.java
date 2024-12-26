package com.jdc.mkt.concurrentAccess;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.CommonFactory;
import com.jdc.mkt.entity.Account;

public class AccountTest extends CommonFactory{
	
	@Test
	@Order(1)
	void insertTest() {
		var em = emf.createEntityManager();
		var acc = new Account();
		acc.setName("Thida");
		acc.setSaving(500000.0);
		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();
	}
	@Test
	@Order(2)
	void updateTest() {
		var th1 = getOperationOne();
		var th2 = getOperationTwo();
		th1.start();
		th2.start();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	private Thread getOperationOne() {
		return new Thread(() -> {
			var em = emf.createEntityManager();
			System.out.println("******************* Operation One Start ******************");
			var acc = em.find(Account.class, 1);
			
			System.out.println("---------------(One) Before Update Account ----------------");
			System.out.println("Account saving amount : "+acc.getSaving());
			em.getTransaction().begin();
			try {
				Thread.sleep(800);
			}catch (Exception e) {
				e.printStackTrace();
			}
			acc.setSaving(acc.getSaving()-100000.0);
			em.flush();
			em.getTransaction().commit();
			em.close();
			System.out.println("--------------- (One) After Update Account ----------------");
			System.out.println("Account saving amount : "+acc.getSaving());
			
		});
	}
	private Thread getOperationTwo() {
		return new Thread(() -> {
			var em = emf.createEntityManager();
			System.out.println("******************* Operation Two Start ******************");
			var acc = em.find(Account.class, 1);
			
			System.out.println("---------------(Two) Before Update Account ----------------");
			System.out.println("Account saving amount : "+acc.getSaving());
			em.getTransaction().begin();
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			em.refresh(acc);
			acc.setSaving(acc.getSaving()+100000.0);
			em.getTransaction().commit();
			em.close();
			System.out.println("--------------- (Two)After Update Account ----------------");
			System.out.println("Account saving amount : "+acc.getSaving());
			
		});
	}
	
}
