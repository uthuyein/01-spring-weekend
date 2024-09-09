package com.jdc.spring.jdbc.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdc.spring.jdbc.DivisionDao;
import com.jdc.spring.jdbc.model.Division;

@Repository
public class DivisionDaoPure implements DivisionDao {

	@Autowired
	private DataSource dataSource;
	private static final String SQL = "select * from division";
	
	@Override
	public List<Division> findAll() {
		var list = new ArrayList<Division>();
		try(var con = dataSource.getConnection();
				var stmt = con.prepareStatement(SQL)){
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var d = new Division();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("name"));
				d.setCapital(rs.getString("capital"));
				d.setRegion(rs.getString("region"));
				list.add(d);
			}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
