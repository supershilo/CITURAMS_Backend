package com.appdev.Rams.Repository;

import com.appdev.Rams.Entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Integer> {

    @Query(value = "SELECT * FROM tblequipment u WHERE u.is_deleted = 0", nativeQuery = true)
    List<EquipmentEntity> getAllEquipment();
}


