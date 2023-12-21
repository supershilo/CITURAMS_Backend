package com.appdev.Rams.Controller;

import com.appdev.Rams.Entity.RoomEntity;
import com.appdev.Rams.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {

	@Autowired
	RoomService rmserv;
	
	@PostMapping("/createRoom")
	public RoomEntity createRoom(@RequestBody RoomEntity room) {
		return rmserv.createRoom(room);
	}
	
	@GetMapping("/getAllRooms")
	public List<RoomEntity> getAllRooms(){
		return rmserv.getAllRooms();
	}

	@GetMapping("/getRoomsByBldgID/{id}")
	public List<RoomEntity> getRoomsByBldgID(@PathVariable int id){
		return rmserv.getRoomsByBldgID(id);
	}

	@GetMapping("/getRoomNameByID/{id}")
	public ResponseEntity<String> getRoomNameByID(@PathVariable int id){
		String name = rmserv.getRoomNameByID(id);

		if(name != null){
			return ResponseEntity.ok(name);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/updateRoom")
	public RoomEntity updateRoom(@RequestParam int id, @RequestBody RoomEntity room) {
		return rmserv.updateRoom(id, room);
	}
	
	@DeleteMapping("/deleteRoom/{id}")
	public String deleteRoom(@PathVariable int id){
		return rmserv.deleteRoom(id);
	}
}


