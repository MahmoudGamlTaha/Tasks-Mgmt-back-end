package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMS_TASK_COMMENT database table.
 * 
 */
@Entity
@Table(name="EMS_TASK_COMMENT")
@NamedQuery(name="EmsTaskComment.findAll", query="SELECT e FROM EmsTaskComment e")
public class EmsTaskComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmsTaskCommentPK id;

	@Column(name="COMMENT_TEXT")
	private String commentText;

	@Column(name="USER_ID")
	private java.math.BigDecimal userId;

	//bi-directional many-to-one association to EmsTask
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="PROJECT_ID", referencedColumnName="PROJECT_ID", insertable = false, updatable = false),
		@JoinColumn(name="TASK_ID", referencedColumnName="TASK_ID", insertable = false, updatable = false)
		})
	private EmsTask emsTask;

	public EmsTaskComment() {
	}

	public EmsTaskCommentPK getId() {
		return this.id;
	}

	public void setId(EmsTaskCommentPK id) {
		this.id = id;
	}

	public String getCommentText() {
		return this.commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public java.math.BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(java.math.BigDecimal userId) {
		this.userId = userId;
	}

	public EmsTask getEmsTask() {
		return this.emsTask;
	}

	public void setEmsTask(EmsTask emsTask) {
		this.emsTask = emsTask;
	}

}