package com.appdev.Rams.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tbladmin")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminID;
    
    @Column(name = "firstname")
    private String fname;

    @Column(name = "lastname")
    private String lname;

    private String email;
    private String password;
    private String department;
    private String position;
    private String role;
    private String contactNum;
    private int isDeleted = 0;

    public AdminEntity() {
        super();
    }

    public AdminEntity(String fname, String lname, String email, String password, String department, String position, String role, String contactNum) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.department = department;
        this.position = position;
        this.role = role;
        this.contactNum = contactNum;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
