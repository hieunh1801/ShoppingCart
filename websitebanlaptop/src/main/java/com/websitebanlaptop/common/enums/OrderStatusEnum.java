package com.websitebanlaptop.common.enums;

public enum OrderStatusEnum {
	ACTIVE(1),
	WAIT(2),
    INACTIVE(0);
    
	OrderStatusEnum(int status) {
    }
    
    private int status;

	public int getStatus() {
		return status;
	}
}
