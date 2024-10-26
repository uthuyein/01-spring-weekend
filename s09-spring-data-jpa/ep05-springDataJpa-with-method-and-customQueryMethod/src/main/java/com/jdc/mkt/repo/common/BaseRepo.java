package com.jdc.mkt.repo.common;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo<T,ID> extends JpaRepository<T, ID> {

	List<T> query(String jpql,Map<String, Object> params);
}
