package com.hc.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.145+0200")
@StaticMetamodel(EmsFinancialRequest.class)
public class EmsFinancialRequest_ {
	public static volatile SingularAttribute<EmsFinancialRequest, Long> requestId;
	public static volatile SingularAttribute<EmsFinancialRequest, BigDecimal> actualHour;
	public static volatile SingularAttribute<EmsFinancialRequest, BigDecimal> actualMinute;
	public static volatile SingularAttribute<EmsFinancialRequest, BigDecimal> hourPrice;
	public static volatile SingularAttribute<EmsFinancialRequest, String> paymentDetails;
	public static volatile SingularAttribute<EmsFinancialRequest, Date> requestDate;
	public static volatile SingularAttribute<EmsFinancialRequest, BigDecimal> requestStatus;
	public static volatile SingularAttribute<EmsFinancialRequest, Date> shakwaDate;
	public static volatile SingularAttribute<EmsFinancialRequest, String> shakwaText;
	public static volatile SingularAttribute<EmsFinancialRequest, EmsExpert> emsExpert;
	public static volatile ListAttribute<EmsFinancialRequest, EmsFinancialRequestDtl> emsFinancialRequestDtls;
}
