package com.hc.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.143+0200")
@StaticMetamodel(EmsExpertExperience.class)
public class EmsExpertExperience_ {
	public static volatile SingularAttribute<EmsExpertExperience, EmsExpertExperiencePK> id;
	public static volatile SingularAttribute<EmsExpertExperience, String> experienceDesc;
	public static volatile SingularAttribute<EmsExpertExperience, Date> experienceEnddate;
	public static volatile SingularAttribute<EmsExpertExperience, Date> experienceStartdate;
	public static volatile SingularAttribute<EmsExpertExperience, String> industry;
	public static volatile SingularAttribute<EmsExpertExperience, String> workName;
	public static volatile SingularAttribute<EmsExpertExperience, EmsExpert> emsExpert;
	public static volatile SingularAttribute<EmsExpertExperience, EmsJobCode> emsJobCode;
}
