package com.mts.security.administration;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.183+0200")
@StaticMetamodel(UserPermission.class)
public class UserPermission_ {
	public static volatile SingularAttribute<UserPermission, Long> USER_ID;
	public static volatile SingularAttribute<UserPermission, Long> RULE_ID;
	public static volatile SingularAttribute<UserPermission, Long> MODULE_ID;
	public static volatile SingularAttribute<UserPermission, String> USER_LOGIN;
	public static volatile SingularAttribute<UserPermission, String> RULE_NAME;
}
