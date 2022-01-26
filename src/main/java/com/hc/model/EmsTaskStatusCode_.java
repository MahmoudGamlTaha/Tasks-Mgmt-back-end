package com.hc.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.172+0200")
@StaticMetamodel(EmsTaskStatusCode.class)
public class EmsTaskStatusCode_ {
	public static volatile SingularAttribute<EmsTaskStatusCode, Long> taskStatusId;
	public static volatile SingularAttribute<EmsTaskStatusCode, String> taskStatusName;
	public static volatile ListAttribute<EmsTaskStatusCode, EmsTask> emsTasks;
}
