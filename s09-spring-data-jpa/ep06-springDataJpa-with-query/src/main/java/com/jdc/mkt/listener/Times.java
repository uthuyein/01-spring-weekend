package com.jdc.mkt.listener;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Times{
	private LocalDateTime createTime;
	private LocalDateTime updateTime; 
}
