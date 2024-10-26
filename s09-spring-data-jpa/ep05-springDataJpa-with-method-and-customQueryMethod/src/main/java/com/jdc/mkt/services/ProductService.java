package com.jdc.mkt.services;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ProductService {

	@PersistenceContext
	private EntityManager em;
	
	
}
