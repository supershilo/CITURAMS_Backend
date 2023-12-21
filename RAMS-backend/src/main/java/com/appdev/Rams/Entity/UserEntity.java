package com.appdev.Rams.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbluser") 
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    @Column(name = "firstname")
    private String fname;
    @Column(name = "lastname")
    private String lname;
    private String email;
    private String password;
    private String contactNum;
    private String department;
    private String role;
    private String position;
    private int isDeleted = 0;

    @Lob
    @Column(name = "profile_image", columnDefinition="BLOB")
    private byte[] profileImage;
    
    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID){
        this.userID = userID;
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

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int isDeleted() {
        return isDeleted;
    }

    public void setDeleted(int deleted) {
        isDeleted = deleted;
    }

    public UserEntity() {
        super();
    }

    public UserEntity(String fname, String lname, String email, String password, String contactNum, String department, String role, String position, byte[] profileImage) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.contactNum = contactNum;
        this.department = department;
        this.role = role;
        this.position = position;
        this.profileImage = profileImage;
    }


}
