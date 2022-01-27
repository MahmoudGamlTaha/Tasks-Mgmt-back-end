package com.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.133+0200")
@StaticMetamodel(EmsEducationDegreeCode.class)
public class EmsEducationDegreeCode_ {
	public static volatile SingularAttribute<EmsEducationDegreeCode, Long> qualClassId;
	public static volatile SingularAttribute<EmsEducationDegreeCode, String> qualClassNameA;
	public static volatile SingularAttribute<EmsEducationDegreeCode, String> qualClassNameE;
	public static volatile ListAttribute<EmsEducationDegreeCode, EmsExpertEducation> emsExpertEducations;
}
