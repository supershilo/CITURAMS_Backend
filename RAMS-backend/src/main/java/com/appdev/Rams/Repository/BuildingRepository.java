package com.appdev.Rams.Repository;

import com.appdev.Rams.Entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer> {

	@Query(value = "SELECT * FROM tblbuilding b WHERE b.is_deleted = 0", nativeQuery = true)
    List<BuildingEntity> findAllBuilding();
}
