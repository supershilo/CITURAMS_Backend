package com.appdev.Rams.Repository;

import com.appdev.Rams.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer >{

	@Query(value = "SELECT * FROM tbldepartment dept WHERE dept.is_deleted = 0", nativeQuery = true)
    List<DepartmentEntity> findAllDepts();
}
