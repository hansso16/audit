package com.soses.audit.common;

/**
 * The Enum AddressTypeEnum.
 *
 * @author hso
 * @since Jan 6, 2022
 */
public enum AddressTypeEnum {

	/** The present. */
	STORE_ADDRESS("1", "Delivery Address/Store Location"), /** The permanent. */
	OFFICE_ADDRESS("2", "Purchasing Office Address"), /** The provincial. */
	WAREHOUSE_ADDRESS("3", "Warehouse Address"),
	OWNER_ADDRESS("4", "Owner Address")
	;
	
	/** The address type. */
	private final String addressType;
	
	/** The address type name. */
	private final String addressTypeName;

	/**
	 * Instantiates a new address type enum.
	 *
	 * @param addressType the address type
	 * @param addressTypeName the address type name
	 */
	private AddressTypeEnum(String addressType, String addressTypeName) {
		this.addressType = addressType;
		this.addressTypeName = addressTypeName;
	}
	
	/**
	 * Gets the address type.
	 *
	 * @return the address type
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * Gets the address type name.
	 *
	 * @return the address type name
	 */
	public String getAddressTypeName() {
		return addressTypeName;
	}

	/**
	 * Value of address type.
	 *
	 * @param addressType the address type
	 * @return the address type enum
	 */
	public static AddressTypeEnum valueOfAddressType(String addressType) {
	    for (AddressTypeEnum e : values()) {
	        if (e.addressType.equals(addressType)) {
	            return e;
	        }
	    }
	    return null;
	}

	public static String deriveAddressType(String addressType) {
		for (AddressTypeEnum e : values()) {
			if (e.addressType.equals(addressType)) {
				return e.getAddressTypeName();
			}
		}
		return null;
	}
}
