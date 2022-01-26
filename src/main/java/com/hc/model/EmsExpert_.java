package com.hc.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.134+0200")
@StaticMetamodel(EmsExpert.class)
public class EmsExpert_ {
	public static volatile SingularAttribute<EmsExpert, Long> expertId;
	public static volatile SingularAttribute<EmsExpert, String> biography;
	public static volatile SingularAttribute<EmsExpert, String> currentAddress;
	public static volatile SingularAttribute<EmsExpert, byte[]> curriculumVitaeFile;
	public static volatile SingularAttribute<EmsExpert, String> expertEmail;
	public static volatile SingularAttribute<EmsExpert, String> expertMobil1;
	public static volatile SingularAttribute<EmsExpert, String> expertMobil2;
	public static volatile SingularAttribute<EmsExpert, String> expertNameA;
	public static volatile SingularAttribute<EmsExpert, String> expertNameE;
	public static volatile SingularAttribute<EmsExpert, String> expertShortName;
	public static volatile SingularAttribute<EmsExpert, byte[]> recentPhotoFile;
	public static volatile SingularAttribute<EmsExpert, BigDecimal> userId;
	public static volatile SingularAttribute<EmsExpert, EmsCityCode> emsCityCode;
	public static volatile SingularAttribute<EmsExpert, EmsCountryCode> emsCountryCode;
	public static volatile ListAttribute<EmsExpert, EmsExpertCertificate> emsExpertCertificates;
	public static volatile ListAttribute<EmsExpert, EmsExpertEducation> emsExpertEducations;
	public static volatile ListAttribute<EmsExpert, EmsExpertExperience> emsExpertExperiences;
	public static volatile ListAttribute<EmsExpert, EmsFinancialRequest> emsFinancialRequests;
	public static volatile ListAttribute<EmsExpert, EmsProjectExpert> emsProjectExperts;
	public static volatile ListAttribute<EmsExpert, EmsTask> emsTasks;
}
