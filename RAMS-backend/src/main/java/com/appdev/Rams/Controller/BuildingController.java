package com.appdev.Rams.Controller;

import com.appdev.Rams.Entity.BuildingEntity;

import com.appdev.Rams.Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
@CrossOrigin(origins = "http://localhost:3000")
public class BuildingController {
	@Autowired
	BuildingService bserv;
	
	@PostMapping("/createBuilding")
	public BuildingEntity createBldg(@RequestBody BuildingEntity building) {
		return bserv.createBldg(building);
	}
	
	@GetMapping("/getAllBuildings")
	public List<BuildingEntity> getAllBuildings(){
		return bserv.getAllBuildings();
	}

	@GetMapping("/getBuildingNameByID/{id}")
	public ResponseEntity<String> getBuildingNameByID(@PathVariable int id){
		String name = bserv.getBuildingNameByID(id);

		if(name != null){
			return ResponseEntity.ok(name);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/updateBuilding")
	public BuildingEntity updateBuilding(@RequestParam int id, @RequestBody BuildingEntity bldg) {
		return bserv.updateBuilding(id, bldg);
	}

	@DeleteMapping("/deleteBuilding/{id}")
	public String deleteBuilding(@PathVariable int id) {
		return bserv.deleteBuilding(id);
	}
}
