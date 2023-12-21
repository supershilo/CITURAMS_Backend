package com.appdev.Rams.Repository;

import com.appdev.Rams.Entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Integer >{

	@Query(value = "SELECT * FROM tblstaff u WHERE u.is_deleted = 0", nativeQuery = true)
    List<StaffEntity> getAllStaff();
}
