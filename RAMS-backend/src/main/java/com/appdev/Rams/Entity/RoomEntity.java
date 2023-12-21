package com.appdev.Rams.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblroom")

public class RoomEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomID;
	
	@Column(name = "RoomNumber")
	private String roomName;
	private int isDeleted;
	private int buildingID = 0;


	public RoomEntity() {
		super();
	}
	
	public RoomEntity(String roomName) {
		super();
		this.roomName = roomName;
	}


	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	public int getRoomID() {
		return roomID;
	}


}
