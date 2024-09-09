package com.jdc.mkt.entity.listener;

import java.io.Serializable;

public interface EnableTimeListener extends Serializable{

	void setTime(Time time);
	Time getTime();
	
}
