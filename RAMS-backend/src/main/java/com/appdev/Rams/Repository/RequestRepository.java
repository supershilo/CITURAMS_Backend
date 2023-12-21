package com.appdev.Rams.Repository;

import com.appdev.Rams.Entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Integer> {

    //@Query(value = "SELECT * FROM tblrequest u WHERE u.status = 'on-going' OR u.status = 'pending'", nativeQuery = true)
    @Query(value = "SELECT * FROM tblrequest u WHERE (u.status = 'on-going' OR u.status = 'pending') AND u.is_deleted = 0", nativeQuery = true)
    List<RequestEntity> getAllOngoingRequest();

    @Query(value = "SELECT * FROM tblrequest u WHERE u.status = 'resolved' AND u.is_deleted = 0", nativeQuery = true)
    List<RequestEntity> getAllResolvedRequest();

    @Query(value = "SELECT * FROM tblrequest u WHERE u.is_deleted = 0", nativeQuery = true)
    List<RequestEntity> findAllRequest();

}
