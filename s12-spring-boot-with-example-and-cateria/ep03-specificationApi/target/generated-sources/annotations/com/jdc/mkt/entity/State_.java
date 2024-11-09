package com.jdc.mkt.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(State.class)
public abstract class State_ {

	public static final String CAPITAL = "capital";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String REGION = "region";

	
	/**
	 * @see com.jdc.mkt.entity.State#capital
	 **/
	public static volatile SingularAttribute<State, String> capital;
	
	/**
	 * @see com.jdc.mkt.entity.State#name
	 **/
	public static volatile SingularAttribute<State, String> name;
	
	/**
	 * @see com.jdc.mkt.entity.State#id
	 **/
	public static volatile SingularAttribute<State, Integer> id;
	
	/**
	 * @see com.jdc.mkt.entity.State#region
	 **/
	public static volatile SingularAttribute<State, Region> region;
	
	/**
	 * @see com.jdc.mkt.entity.State
	 **/
	public static volatile EntityType<State> class_;

}

