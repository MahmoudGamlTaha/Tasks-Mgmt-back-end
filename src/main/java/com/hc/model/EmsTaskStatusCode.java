package com.hc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMS_TASK_STATUS_CODE database table.
 * 
 */
@Entity
@Table(name="EMS_TASK_STATUS_CODE")
@NamedQuery(name="EmsTaskStatusCode.findAll", query="SELECT e FROM EmsTaskStatusCode e")
public class EmsTaskStatusCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TASK_STATUS_ID")
	private long taskStatusId;

	@Column(name="TASK_STATUS_NAME")
	private String taskStatusName;

//	//bi-directional many-to-one association to EmsTask
//	@OneToMany(mappedBy="emsTaskStatusCode")
//	private List<EmsTask> emsTasks;

	public EmsTaskStatusCode() {
	}

	public long getTaskStatusId() {
		return this.taskStatusId;
	}

	public void setTaskStatusId(long taskStatusId) {
		this.taskStatusId = taskStatusId;
	}

	public String getTaskStatusName() {
		return this.taskStatusName;
	}

	public void setTaskStatusName(String taskStatusName) {
		this.taskStatusName = taskStatusName;
	}

//	public List<EmsTask> getEmsTasks() {
//		return this.emsTasks;
//	}
//
//	public void setEmsTasks(List<EmsTask> emsTasks) {
//		this.emsTasks = emsTasks;
//	}
//
//	public EmsTask addEmsTask(EmsTask emsTask) {
//		getEmsTasks().add(emsTask);
//		emsTask.setEmsTaskStatusCode(this);
//
//		return emsTask;
//	}
//
//	public EmsTask removeEmsTask(EmsTask emsTask) {
//		getEmsTasks().remove(emsTask);
//		emsTask.setEmsTaskStatusCode(null);
//
//		return emsTask;
//	}

}