package com.appdev.Rams.Controller;

import com.appdev.Rams.Entity.DepartmentEntity;
import com.appdev.Rams.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")

public class DepartmentController {
	@Autowired
	DepartmentService deptServ;
	
	@PostMapping("/createDept")
	public DepartmentEntity createDept(@RequestBody DepartmentEntity dept) {
	    return deptServ.createDept(dept);
	}
	
	@GetMapping("/getAllDepts")
	public List<DepartmentEntity> getAllDepts(){
		return deptServ.getAllDepts();
	}
	
	@PutMapping("/updateDept")
	public DepartmentEntity updateDept(@RequestParam int id, @RequestBody DepartmentEntity newDept) {
		return deptServ.updateDept(id, newDept);
	}
	
	@DeleteMapping("/deleteDept/{id}")
	public String deleteDept(@PathVariable int id) {
		return deptServ.deleteDept(id);
	}
}
