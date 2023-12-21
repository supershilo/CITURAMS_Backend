package com.appdev.Rams.Controller;

import com.appdev.Rams.Entity.UserEntity;
import com.appdev.Rams.Service.UserService;

import org.hibernate.engine.internal.Collections;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000") 
public class UserController {
    @Autowired
    UserService userServ;

    @PostMapping("/login")
    public ResponseEntity<java.util.Map<String, String>> login(@RequestBody UserEntity loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        UserEntity user = userServ.getUserByEmail(email);

        if (user != null && password.equals(user.getPassword())) {
            // Authentication successful
            String userRole = userServ.getUserRole(email);

            java.util.Map<String, String> responseData = new HashMap<>();
            responseData.put("message", "Login successful");
            responseData.put("role", userRole);

            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } else {
            // Authentication failed
            return new ResponseEntity<>(java.util.Collections.singletonMap("message", "Invalid email or password"), HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody UserEntity user){
        return userServ.createUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers(){
        return userServ.getAllUser();
    }

    @PutMapping("/admin/updateUser")
    public UserEntity adminUpdatesUser(@RequestParam int userID, @RequestBody UserEntity newUserDetails){
        return userServ.adminUpdatesUser(userID, newUserDetails);


    }

    @PutMapping("/updateUser")
   public ResponseEntity<String> updateUser(@RequestParam int userID,
                                           @RequestParam(required = false) String contactNum,
                                           @RequestParam(required = false) String password,
                                           @RequestParam(value="profileImage", required = false) MultipartFile profileImage) {
      try {
         userServ.updateUser(userID, contactNum, password, profileImage);
         return ResponseEntity.ok("User details updated successfully");
      } catch (Exception e) {
         return ResponseEntity.status(500).body("Error updating user details");
      }
   }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return userServ.deleteUser(id);
    }

    @GetMapping("/getUserData")
    public ResponseEntity<UserEntity> getUserData(@RequestParam String email) {
        // Assuming you identify users by their email addresses, adjust as needed

        // Fetch user data by email
        UserEntity user = userServ.getUserByEmail(email);

        if (user != null) {
            // Return user data if found
            return ResponseEntity.ok(user);
        } else {
            // Return 404 if user not found
            return ResponseEntity.notFound().build();
        }
    }


    //---------------------------------------------------------------------------
    @GetMapping("/getUserID/{email}")
    public ResponseEntity<Integer> getUserIdByEmail(@PathVariable String email) {
        int userId = userServ.getUserIDByEmail(email);

        if (userId != -1) {
            return ResponseEntity.ok(userId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getUserName/{email}")
    public ResponseEntity<String> getUserNameByEmail(@PathVariable String email) {
        String name = userServ.getUserNameByEmail(email);

        if (name != null) {
            return ResponseEntity.ok(name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getRole/{email}")
    public ResponseEntity<String> getRoleByEmail(@PathVariable String email){
        String role = userServ.getRoleByEmail(email);

        if(role != null){
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
