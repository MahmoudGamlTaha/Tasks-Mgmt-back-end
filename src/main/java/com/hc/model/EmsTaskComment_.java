package com.hc.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.165+0200")
@StaticMetamodel(EmsTaskComment.class)
public class EmsTaskComment_ {
	public static volatile SingularAttribute<EmsTaskComment, EmsTaskCommentPK> id;
	public static volatile SingularAttribute<EmsTaskComment, String> commentText;
	public static volatile SingularAttribute<EmsTaskComment, BigDecimal> userId;
	public static volatile SingularAttribute<EmsTaskComment, EmsTask> emsTask;
}
