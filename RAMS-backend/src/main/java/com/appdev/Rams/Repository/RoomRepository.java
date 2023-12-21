package com.appdev.Rams.Repository;

import com.appdev.Rams.Entity.RoomEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer>{
	
	@Query(value = "SELECT * FROM tblroom r WHERE r.is_deleted = 0", nativeQuery = true)
	List<RoomEntity> findAllRooms();

	List<RoomEntity> findRoomsByBuildingID(int buildingID);
}
