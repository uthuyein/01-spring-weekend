package com.jdc.mkt.entity.listener;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class EntityListener {

	@PrePersist
	public void createTime(Object obj) {
		if(obj instanceof EnableTimeListener entity) {
			Time time = entity.getTime();
			if(null == time) {
				time = new Time();
				entity.setTime(time);
			}
			time.setCreateTime(LocalDateTime.now());
		}
	}
	@PreUpdate
	public void updateTime(Object obj) {
		if(obj instanceof EnableTimeListener entity) {
			Time time = entity.getTime();
			if(null == time) {
				time = new Time();
				entity.setTime(time);
			}
			time.setUpdateTime(LocalDateTime.now());
		}
	}
}
