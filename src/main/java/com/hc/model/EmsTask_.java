package com.hc.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.163+0200")
@StaticMetamodel(EmsTask.class)
public class EmsTask_ {
	public static volatile SingularAttribute<EmsTask, EmsTaskPK> id;
	public static volatile SingularAttribute<EmsTask, BigDecimal> taskActualHour;
	public static volatile SingularAttribute<EmsTask, BigDecimal> taskActualMinute;
	public static volatile SingularAttribute<EmsTask, Date> taskCreateDate;
	public static volatile SingularAttribute<EmsTask, String> taskDesc;
	public static volatile SingularAttribute<EmsTask, Date> taskExpectedDate;
	public static volatile SingularAttribute<EmsTask, BigDecimal> taskExpectedHour;
	public static volatile SingularAttribute<EmsTask, BigDecimal> taskExpectedMinute;
	public static volatile SingularAttribute<EmsTask, String> taskName;
	public static volatile SingularAttribute<EmsTask, BigDecimal> userId;
	public static volatile ListAttribute<EmsTask, EmsFinancialRequestDtl> emsFinancialRequestDtls;
	public static volatile SingularAttribute<EmsTask, EmsExpert> emsExpert;
	public static volatile SingularAttribute<EmsTask, EmsTask> emsTask;
	public static volatile ListAttribute<EmsTask, EmsTask> emsTasks;
	public static volatile SingularAttribute<EmsTask, EmsTaskStatusCode> emsTaskStatusCode;
	public static volatile ListAttribute<EmsTask, EmsTaskComment> emsTaskComments;
	public static volatile ListAttribute<EmsTask, EmsTaskDocument> emsTaskDocuments;
}
