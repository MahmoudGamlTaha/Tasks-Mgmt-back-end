package com.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.173+0200")
@StaticMetamodel(EmsUniversityCode.class)
public class EmsUniversityCode_ {
	public static volatile SingularAttribute<EmsUniversityCode, Long> universityId;
	public static volatile SingularAttribute<EmsUniversityCode, String> universityNameA;
	public static volatile SingularAttribute<EmsUniversityCode, String> universityNameE;
	public static volatile ListAttribute<EmsUniversityCode, EmsExpertCertificate> emsExpertCertificates;
	public static volatile ListAttribute<EmsUniversityCode, EmsExpertEducation> emsExpertEducations;
	public static volatile SingularAttribute<EmsUniversityCode, EmsCityCode> emsCityCode;
}
