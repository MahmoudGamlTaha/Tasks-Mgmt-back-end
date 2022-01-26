package com.hc.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.140+0200")
@StaticMetamodel(EmsExpertEducation.class)
public class EmsExpertEducation_ {
	public static volatile SingularAttribute<EmsExpertEducation, EmsExpertEducationPK> id;
	public static volatile SingularAttribute<EmsExpertEducation, String> educationDesc;
	public static volatile SingularAttribute<EmsExpertEducation, Date> educationEnddate;
	public static volatile SingularAttribute<EmsExpertEducation, String> educationRating;
	public static volatile SingularAttribute<EmsExpertEducation, Date> educationStartdate;
	public static volatile SingularAttribute<EmsExpertEducation, EmsEducationDegreeCode> emsEducationDegreeCode;
	public static volatile SingularAttribute<EmsExpertEducation, EmsExpert> emsExpert;
	public static volatile SingularAttribute<EmsExpertEducation, EmsStudyFieldCode> emsStudyFieldCode;
	public static volatile SingularAttribute<EmsExpertEducation, EmsUniversityCode> emsUniversityCode;
}
