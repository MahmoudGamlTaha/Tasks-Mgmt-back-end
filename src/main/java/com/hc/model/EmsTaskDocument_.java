package com.hc.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.168+0200")
@StaticMetamodel(EmsTaskDocument.class)
public class EmsTaskDocument_ {
	public static volatile SingularAttribute<EmsTaskDocument, EmsTaskDocumentPK> id;
	public static volatile SingularAttribute<EmsTaskDocument, byte[]> documentFile;
	public static volatile SingularAttribute<EmsTaskDocument, String> documentText;
	public static volatile SingularAttribute<EmsTaskDocument, BigDecimal> userId;
	public static volatile SingularAttribute<EmsTaskDocument, EmsTask> emsTask;
}
