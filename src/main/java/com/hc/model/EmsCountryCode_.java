package com.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.131+0200")
@StaticMetamodel(EmsCountryCode.class)
public class EmsCountryCode_ {
	public static volatile SingularAttribute<EmsCountryCode, Long> countryId;
	public static volatile SingularAttribute<EmsCountryCode, String> countryCode;
	public static volatile SingularAttribute<EmsCountryCode, String> countryNameA;
	public static volatile SingularAttribute<EmsCountryCode, String> countryNameE;
	public static volatile ListAttribute<EmsCountryCode, EmsExpert> emsExperts;
	public static volatile ListAttribute<EmsCountryCode, EmsGovernorateCode> emsGovernorateCodes;
}
