package com.hc.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.135+0200")
@StaticMetamodel(EmsExpertCertificate.class)
public class EmsExpertCertificate_ {
	public static volatile SingularAttribute<EmsExpertCertificate, EmsExpertCertificatePK> id;
	public static volatile SingularAttribute<EmsExpertCertificate, String> certificateDesc;
	public static volatile SingularAttribute<EmsExpertCertificate, Date> certificateEnddate;
	public static volatile SingularAttribute<EmsExpertCertificate, String> certificateLink;
	public static volatile SingularAttribute<EmsExpertCertificate, String> certificateName;
	public static volatile SingularAttribute<EmsExpertCertificate, String> certificateRefNumber;
	public static volatile SingularAttribute<EmsExpertCertificate, Date> certificateStartdate;
	public static volatile SingularAttribute<EmsExpertCertificate, EmsExpert> emsExpert;
	public static volatile SingularAttribute<EmsExpertCertificate, EmsUniversityCode> emsUniversityCode;
}
