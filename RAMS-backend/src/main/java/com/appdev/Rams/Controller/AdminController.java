package com.appdev.Rams.Controller;

import com.appdev.Rams.Entity.AdminEntity;
import com.appdev.Rams.Entity.UserEntity;
import com.appdev.Rams.Service.AdminService;
import com.appdev.Rams.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000") 
public class AdminController {
    @Autowired
    AdminService adminServ;

    @Autowired
    UserService userServ;

    //Create User account
    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody UserEntity user){
       return userServ.createUser(user);
    }

    //Create Admin account 
    @PostMapping("/createAdmin")
    public AdminEntity createAdmin(@RequestBody AdminEntity admin){
        return adminServ.createAdmin(admin);
    }
    
    @GetMapping("/getAllAdmins")
    public List<AdminEntity> getAllAdmin(){
        return adminServ.getAllAdmin();
    }

    @PutMapping("/updateAdmin")
    public AdminEntity updateAdmin(@RequestParam int adminID, @RequestBody AdminEntity newAdminDetails){
        return adminServ.updateAdmin(adminID, newAdminDetails);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return userServ.deleteUser(id);
    }
    
    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable int id){
        return adminServ.deleteAdmin(id);
    }





}
