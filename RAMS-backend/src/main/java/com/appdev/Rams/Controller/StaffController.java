package com.appdev.Rams.Controller;

import com.appdev.Rams.Entity.StaffEntity;
import com.appdev.Rams.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@CrossOrigin(origins = "http://localhost:3000")
public class StaffController {
	@Autowired
	StaffService staffServ;
	
	@PostMapping("/createStaff")
	public StaffEntity createStaff(@RequestBody StaffEntity staff) {
	    return staffServ.createStaff(staff);
	}
	
	@GetMapping("/getAllStaff")
	public List<StaffEntity> getAllStaff(){
		return staffServ.getAllStaff();
	}
	
	@PutMapping("/updateStaff")
	public StaffEntity updateStaff(@RequestParam int id, @RequestBody StaffEntity newStaffDetails) {
		return staffServ.updateStaff(id, newStaffDetails);
	}
	
	@DeleteMapping("/deleteStaff/{id}")
	public String deleteStaff(@PathVariable int id) {
		return staffServ.deleteStaff(id);
	}
}
