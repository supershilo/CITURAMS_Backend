package com.appdev.Rams.Repository;

import com.appdev.Rams.Entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

    @Query(value = "SELECT * FROM tbladmin u WHERE u.is_deleted = 0", nativeQuery = true)
    List<AdminEntity> findAllAdmin();
}
