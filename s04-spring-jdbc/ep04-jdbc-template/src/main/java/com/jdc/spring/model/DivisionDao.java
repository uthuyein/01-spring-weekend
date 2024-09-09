package com.jdc.spring.model;

import java.util.List;

import com.jdc.spring.model.dto.Division;
import com.jdc.spring.model.dto.DivisionForm;

public interface DivisionDao {

	int create(DivisionForm form);
	long countAll();
	Division findById(int id);
	boolean update(int id,DivisionForm form);
	boolean delete(int id);
	
	List<Division> findByName(String name);
	List<Division> findByRegion(String region);
	List<Division> findByCapital(String capital);	
	
}
