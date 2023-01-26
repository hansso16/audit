package com.soses.audit.util;

import com.soses.audit.dto.UserTO;
import com.soses.audit.entity.User;

public class UserUtil {

	public static UserTO transformUserEntity(User user) {
		if (user == null) { return null; }
		UserTO userTO = new UserTO();
		userTO.setEntryTimestamp(user.getEntryTimestamp());
		userTO.setLastChangedUser(user.getLastChangedUser());
		userTO.setRole(user.getRole());
		userTO.setTerminationDate(user.getTerminationDate());
		userTO.setUserCode(user.getUserCode());
		userTO.setUsername(user.getUsername());
		return userTO;
	}
}
