package com.appdev.Rams.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblrequest")
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestID;
    private String userName;
    private int reqUserID = 0;
    private String building;
    private String room;
    private String equipment;
    private String message;
    private String status = "pending";
    private String date;
    private String staff = "None";
    private int isDeleted = 0;
    private String remarksDateTime;
    private String adminName;
    private String remarksMsg;
    private boolean isRemarked = false;

    public RequestEntity() {
        super();
    }

    public RequestEntity(String userName, int reqUserID, String building, String room, String equipment, String message, String status, String date, String staff, String remarksDateTime, String adminName, String remarksMsg, boolean isRemarked) {
        this.userName = userName;
        this.reqUserID = reqUserID;
        this.building = building;
        this.room = room;
        this.equipment = equipment;
        this.message = message;
        this.status = status;
        this.date = date;
        this.staff = staff;
        this.remarksDateTime = remarksDateTime;
        this.adminName = adminName;
        this.remarksMsg = remarksMsg;
        this.isRemarked = isRemarked;
    }

    public boolean isRemarked() {
        return isRemarked;
    }

    public void setRemarked(boolean remarked) {
        isRemarked = remarked;
    }



    public String getRemarksDateTime() {
        return remarksDateTime;
    }

    public void setRemarksDateTime(String remarksDateTime) {
        this.remarksDateTime = remarksDateTime;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getRemarksMsg() {
        return remarksMsg;
    }

    public void setRemarksMsg(String remarksMsg) {
        this.remarksMsg = remarksMsg;
    }

    public int getRequestID() {
        return requestID;
    }

    public int getReqUserID() {
        return reqUserID;
    }

    public void setReqUserID(int reqUserID) {
        this.reqUserID = reqUserID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}

