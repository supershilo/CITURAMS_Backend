package com.appdev.Rams.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblstaff")
public class StaffEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffID;
	
	@Column(name = "firstname")
	private String fname;
	@Column(name = "lastname")
	private String lname;
	private String email;
	private String contactNum;
	private String status;
	private int isDeleted = 0;

	public StaffEntity(String fname, String lname, String email, String contactNum, String status) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contactNum = contactNum;
		this.status = status;
	}

	public StaffEntity() {
		super();
	}

	public int getStaffID() {
		return staffID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
}
