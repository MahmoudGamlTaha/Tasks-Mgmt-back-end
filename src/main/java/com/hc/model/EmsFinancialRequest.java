package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMS_FINANCIAL_REQUEST database table.
 * 
 */
@Entity
@Table(name="EMS_FINANCIAL_REQUEST")
@NamedQuery(name="EmsFinancialRequest.findAll", query="SELECT e FROM EmsFinancialRequest e")
public class EmsFinancialRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REQUEST_ID")
	private long requestId;

	@Column(name="ACTUAL_HOUR")
	private BigDecimal actualHour;

	@Column(name="ACTUAL_MINUTE")
	private BigDecimal actualMinute;

	@Column(name="HOUR_PRICE")
	private BigDecimal hourPrice;

	@Column(name="PAYMENT_DETAILS")
	private String paymentDetails;

	@Temporal(TemporalType.DATE)
	@Column(name="REQUEST_DATE")
	private Date requestDate;

	@Column(name="REQUEST_STATUS")
	private BigDecimal requestStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="SHAKWA_DATE")
	private Date shakwaDate;

	@Column(name="SHAKWA_TEXT")
	private String shakwaText;

	//bi-directional many-to-one association to EmsExpert
	@ManyToOne
	@JoinColumn(name="EXPERT_ID", insertable = false, updatable = false)
	private EmsExpert emsExpert;

	//bi-directional many-to-one association to EmsFinancialRequestDtl
	@OneToMany(mappedBy="emsFinancialRequest")
	private List<EmsFinancialRequestDtl> emsFinancialRequestDtls;

	public EmsFinancialRequest() {
	}

	public long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public BigDecimal getActualHour() {
		return this.actualHour;
	}

	public void setActualHour(BigDecimal actualHour) {
		this.actualHour = actualHour;
	}

	public BigDecimal getActualMinute() {
		return this.actualMinute;
	}

	public void setActualMinute(BigDecimal actualMinute) {
		this.actualMinute = actualMinute;
	}

	public BigDecimal getHourPrice() {
		return this.hourPrice;
	}

	public void setHourPrice(BigDecimal hourPrice) {
		this.hourPrice = hourPrice;
	}

	public String getPaymentDetails() {
		return this.paymentDetails;
	}

	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public BigDecimal getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(BigDecimal requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Date getShakwaDate() {
		return this.shakwaDate;
	}

	public void setShakwaDate(Date shakwaDate) {
		this.shakwaDate = shakwaDate;
	}

	public String getShakwaText() {
		return this.shakwaText;
	}

	public void setShakwaText(String shakwaText) {
		this.shakwaText = shakwaText;
	}

	public EmsExpert getEmsExpert() {
		return this.emsExpert;
	}

	public void setEmsExpert(EmsExpert emsExpert) {
		this.emsExpert = emsExpert;
	}

	public List<EmsFinancialRequestDtl> getEmsFinancialRequestDtls() {
		return this.emsFinancialRequestDtls;
	}

	public void setEmsFinancialRequestDtls(List<EmsFinancialRequestDtl> emsFinancialRequestDtls) {
		this.emsFinancialRequestDtls = emsFinancialRequestDtls;
	}

	public EmsFinancialRequestDtl addEmsFinancialRequestDtl(EmsFinancialRequestDtl emsFinancialRequestDtl) {
		getEmsFinancialRequestDtls().add(emsFinancialRequestDtl);
		emsFinancialRequestDtl.setEmsFinancialRequest(this);

		return emsFinancialRequestDtl;
	}

	public EmsFinancialRequestDtl removeEmsFinancialRequestDtl(EmsFinancialRequestDtl emsFinancialRequestDtl) {
		getEmsFinancialRequestDtls().remove(emsFinancialRequestDtl);
		emsFinancialRequestDtl.setEmsFinancialRequest(null);

		return emsFinancialRequestDtl;
	}

}