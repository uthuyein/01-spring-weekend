package com.jdc.mkt.listener;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class TimeListener {
	
	@PrePersist
	void createTime(Object obj) {
		if(obj instanceof EnableTimeListener entity) {
			var times = entity.getTimes();
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setCreateTime(LocalDateTime.now());		
		}
	}
	
	@PreUpdate
	void updateTime(Object obj) {
		if(obj instanceof EnableTimeListener entity) {
			var times = entity.getTimes();
			if(null == times) {
				times = new Times();
				entity.setTimes(times);
			}
			times.setUpdateTime(LocalDateTime.now());		
		}
	}
}
