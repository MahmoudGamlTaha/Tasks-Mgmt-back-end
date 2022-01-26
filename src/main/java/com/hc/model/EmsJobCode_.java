package com.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.152+0200")
@StaticMetamodel(EmsJobCode.class)
public class EmsJobCode_ {
	public static volatile SingularAttribute<EmsJobCode, String> jobId;
	public static volatile SingularAttribute<EmsJobCode, String> jobNameA;
	public static volatile SingularAttribute<EmsJobCode, String> jobNameE;
	public static volatile ListAttribute<EmsJobCode, EmsExpertExperience> emsExpertExperiences;
}
