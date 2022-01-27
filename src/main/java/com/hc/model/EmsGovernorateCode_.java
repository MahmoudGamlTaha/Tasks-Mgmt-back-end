package com.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.150+0200")
@StaticMetamodel(EmsGovernorateCode.class)
public class EmsGovernorateCode_ {
	public static volatile SingularAttribute<EmsGovernorateCode, EmsGovernorateCodePK> id;
	public static volatile SingularAttribute<EmsGovernorateCode, String> governorateCode;
	public static volatile SingularAttribute<EmsGovernorateCode, String> governorateNameA;
	public static volatile SingularAttribute<EmsGovernorateCode, String> governorateNameE;
	public static volatile ListAttribute<EmsGovernorateCode, EmsCityCode> emsCityCodes;
	public static volatile SingularAttribute<EmsGovernorateCode, EmsCountryCode> emsCountryCode;
}
