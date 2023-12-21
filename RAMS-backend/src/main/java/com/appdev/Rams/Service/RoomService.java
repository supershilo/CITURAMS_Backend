package com.appdev.Rams.Service;


import com.appdev.Rams.Entity.RoomEntity;
import com.appdev.Rams.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoomService {
	@Autowired
	RoomRepository rmrepo;
	
	
	public RoomEntity createRoom(RoomEntity room) {
		return rmrepo.save(room);
	}
	
	public List<RoomEntity> getAllRooms(){
		return rmrepo.findAllRooms();
	}

    public List<RoomEntity> getRoomsByBldgID(int id){
        return rmrepo.findRoomsByBuildingID(id);
    }

    public String getRoomNameByID(int id){
        RoomEntity room = rmrepo.findById(id).orElseThrow(
                () -> new NoSuchElementException("Room with ID " + id + " not found.")
        );
        return room.getRoomName();

    }
	
	@SuppressWarnings("finally")
    public RoomEntity updateRoom(int id, RoomEntity newRoomName){
        RoomEntity room = new RoomEntity();

        try{
            //Search room id
            room = rmrepo.findById(id).get();
            //assigning new data to the user entity
            room.setRoomName(newRoomName.getRoomName());
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException("Room " + id + " not found.");
        } finally {
            return rmrepo.save(room);
        }

    }
	
	public String deleteRoom(int id){
        String msg = "";
        Optional<RoomEntity> optionalRoom = rmrepo.findById(id);

        if (optionalRoom.isPresent()) {
            RoomEntity rooms = optionalRoom.get();
            rooms.setIsDeleted(1);
            rmrepo.save(rooms);

            msg = "Room " + rooms.getRoomName() + " is successfully deleted.";
        } else {
            msg = "Invalid Request, Room not found.";
        }

        return msg;
	}
}
