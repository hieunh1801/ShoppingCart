package com.websitebanlaptop.common.enums;

public enum LaptopStatusEnum {
    ACTIVE(1),
    INACTIVE(0);
    
    LaptopStatusEnum(int status) {
    }
    
    private int status;

	public int getStatus() {
		return status;
	}
}
