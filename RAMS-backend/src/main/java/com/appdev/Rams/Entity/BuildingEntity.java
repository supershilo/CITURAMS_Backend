package com.appdev.Rams.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblbuilding")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int building_id;
	
	@Column(name = "building_Name")
	private String buildingName;
	private int isDeleted = 0;
	public int isDeleted() {
        return isDeleted;
    }
	
	public void setDeleted(int deleted) {
		this.isDeleted = deleted;
	}

	public BuildingEntity() {
		super();
	}

	public BuildingEntity(String buildingName) {
		super();
		this.buildingName = buildingName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public int getBuilding_id() {
		return building_id;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
}
