package com.appdev.Rams.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblequipment")
public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipmentID;
    private String equipmentName;
    private int isDeleted = 0;

    public EquipmentEntity() {
        super();
    }

    public EquipmentEntity(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }


}
