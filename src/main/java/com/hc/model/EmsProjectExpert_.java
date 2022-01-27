package com.hc.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-10T11:44:59.153+0200")
@StaticMetamodel(EmsProjectExpert.class)
public class EmsProjectExpert_ {
	public static volatile SingularAttribute<EmsProjectExpert, EmsProjectExpertPK> id;
	public static volatile SingularAttribute<EmsProjectExpert, BigDecimal> hourPrice;
	public static volatile SingularAttribute<EmsProjectExpert, EmsExpert> emsExpert;
}
