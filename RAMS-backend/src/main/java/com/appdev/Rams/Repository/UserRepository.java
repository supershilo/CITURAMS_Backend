package com.appdev.Rams.Repository;

import com.appdev.Rams.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT * FROM tbluser u WHERE u.is_deleted = 0", nativeQuery = true)
    List<UserEntity> findAllUsers();

    UserEntity findByEmail(String email);
    

    // Add logging to this method
    default UserEntity findByEmailWithLogging(String email) {
        System.out.println("Searching for user by email: " + email);
        UserEntity user = findByEmail(email);
        System.out.println("Found user: " + user);
        return user;
    }
}
