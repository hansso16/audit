package com.soses.audit.common;

public enum PhoneTypeEnum {

	MOBILE("1", "Mobile Number"), 
	OFFICE("2", "Office Number"), 
	WORK("3", "Work Number"),
	;
	
	private final String phoneType;
	
	private final String phoneTypeName;

	private PhoneTypeEnum(String phoneType, String phoneTypeName) {
		this.phoneType = phoneType;
		this.phoneTypeName = phoneTypeName;
	}

	
	public String getPhoneType() {
		return phoneType;
	}


	public String getPhoneTypeName() {
		return phoneTypeName;
	}


	public static PhoneTypeEnum valueOfAddressType(String phoneType) {
	    for (PhoneTypeEnum e : values()) {
	        if (e.phoneType.equals(phoneType)) {
	            return e;
	        }
	    }
	    return null;
	}

	public static String derivePhoneTypeName(String phoneType) {
		for (PhoneTypeEnum e : values()) {
			if (e.phoneType.equals(phoneType)) {
				return e.getPhoneTypeName();
			}
		}
		return null;
	}
}
