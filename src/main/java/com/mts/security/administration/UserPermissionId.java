package com.mts.security.administration;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserPermissionId implements Serializable{

	private Long USER_ID;
	private Long RULE_ID;
	private Long MODULE_ID;

	@Override
	public int hashCode() {
		return Objects.hash(MODULE_ID, RULE_ID, USER_ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPermissionId other = (UserPermissionId) obj;
		return Objects.equals(MODULE_ID, other.MODULE_ID) && Objects.equals(RULE_ID, other.RULE_ID)
				&& Objects.equals(USER_ID, other.USER_ID);
	}
}
