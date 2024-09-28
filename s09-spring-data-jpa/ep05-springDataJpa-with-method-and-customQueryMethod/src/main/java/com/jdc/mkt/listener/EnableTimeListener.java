package com.jdc.mkt.listener;

import java.io.Serializable;

public interface EnableTimeListener extends Serializable{

	void setTimes(Times time);
	Times getTimes();
}
