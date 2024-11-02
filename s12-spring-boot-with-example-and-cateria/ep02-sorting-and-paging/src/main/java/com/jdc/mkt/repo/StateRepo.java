package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.entity.State;

public interface StateRepo extends JpaRepository<State, Integer>{

	List<State> findByNameLikeOrderByCapital(String name);
	
	@Query(value = "select s from State s where s.name like :name order by s.capital ")
	List<State> findByStateNameLike(@Param("name") String name);
	
	List<State> findByNameLike(String name,Sort sort);
	
	Page<State> findByRegionNameLike(String name,Pageable page);
	
	@Query(value = "select s from State s where s.name like :name ",
			countQuery = "select count(s) from State s where s.name like :name" )
	Page<State> findByStateLike(@Param("name") String name,Pageable page);
}
