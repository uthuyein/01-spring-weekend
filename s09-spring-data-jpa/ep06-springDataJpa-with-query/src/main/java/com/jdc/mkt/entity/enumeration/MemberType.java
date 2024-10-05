package com.jdc.mkt.entity.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberType {
	SILVER(3),GOLD(5),PLATINUM(7),DIAMOND(10);
	
	private final Integer percent;
	
	
}
