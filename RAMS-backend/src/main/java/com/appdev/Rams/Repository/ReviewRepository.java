package com.appdev.Rams.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appdev.Rams.Entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    @Query(value = "SELECT * FROM tblreview u WHERE u.is_deleted = 0", nativeQuery = true)
    List<ReviewEntity> findAllReviews();
    
}
