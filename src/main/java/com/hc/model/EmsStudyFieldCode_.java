package com.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.162+0200")
@StaticMetamodel(EmsStudyFieldCode.class)
public class EmsStudyFieldCode_ {
	public static volatile SingularAttribute<EmsStudyFieldCode, Long> studyFieldId;
	public static volatile SingularAttribute<EmsStudyFieldCode, String> studyFieldNameA;
	public static volatile SingularAttribute<EmsStudyFieldCode, String> studyFieldNameE;
	public static volatile ListAttribute<EmsStudyFieldCode, EmsExpertEducation> emsExpertEducations;
}
