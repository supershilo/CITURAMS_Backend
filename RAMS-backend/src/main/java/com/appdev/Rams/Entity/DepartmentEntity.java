package com.appdev.Rams.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tbldepartment")
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptID;
	
	@Column(name = "DepartmentName")
	private String deptName;
	
	private int isDeleted;

	public DepartmentEntity() {
		super();
	}

	public DepartmentEntity(int deptID,int isDeleted, String deptName) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
		this.isDeleted = isDeleted;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public int isDeleted() {
        return isDeleted;
    }
	
	public void setDeleted(int deleted) {
        isDeleted = deleted;
    }
}
