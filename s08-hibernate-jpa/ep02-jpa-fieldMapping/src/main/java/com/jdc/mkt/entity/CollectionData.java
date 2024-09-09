package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "data_tbl")
public class CollectionData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	@NonNull
	private String name;
	
	@ElementCollection
	@OrderBy("value desc")
	@Temporal(TemporalType.DATE)
	@Column(name = "value",nullable = false,length = 45)
	@CollectionTable(name = "list_tbl",joinColumns = {@JoinColumn(name = "data_id")})
	private List<Date> lists;
	
	@ElementCollection
	@OrderColumn(name = "value")
	@Enumerated(EnumType.STRING)
	@Column(name = "value",nullable = false,length = 45)
	@CollectionTable(name = "set_tbl",joinColumns = {@JoinColumn(name = "data_id")})
	private Set<Day> sets;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "map_key",length = 45)
	@Column(name = "value",nullable = false,length = 45)
	@CollectionTable(name =  "map_tbl",joinColumns = {@JoinColumn(name = "data_id")})
	private Map<Day, Day> maps;
	
//	@ElementCollection
//	private List<CustomerPk> customers;
	
	enum Day{
		MON,TUE,WED,THUR,FRI,SAT,SUN;
	}
	
}
