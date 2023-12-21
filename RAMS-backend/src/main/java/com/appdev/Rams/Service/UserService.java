    package com.appdev.Rams.Service;

    import com.appdev.Rams.Entity.UserEntity;
    import com.appdev.Rams.Repository.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
    
    import java.io.IOException;

    import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
    public class UserService {
        @Autowired
        UserRepository userRepo;

        public UserEntity authenticateUser(String email, String password) {
            UserEntity user = userRepo.findByEmail(email);

            if (user != null && user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        }

        public UserEntity getUserByEmail(String email) {
            return userRepo.findByEmail(email);
        }

        public String getUserRole(String email) {
            UserEntity user = userRepo.findByEmail(email);
        
            if (user != null) {
                return user.getRole();
            }
        
            // Handle the case where the user or role is not found
            throw new RuntimeException("User or role not found for email: " + email);
        }
        
        //Create or insert student record in tbluser
        public UserEntity createUser(UserEntity user){
            return userRepo.save(user);
        }

        //Read all records in tbluser
        public List<UserEntity> getAllUser(){
            return userRepo.findAllUsers();
        }


        //Update a user record in the database
        public UserEntity adminUpdatesUser(int userID, UserEntity newUserDetails){
            UserEntity user = new UserEntity();

            try{
                //Search user id
                user = userRepo.findById(userID).get();
                //assigning new data to the user entity
                user.setFname(newUserDetails.getFname());
                user.setLname(newUserDetails.getLname());
                user.setEmail(newUserDetails.getEmail());
                user.setDepartment(newUserDetails.getDepartment());
                user.setRole(newUserDetails.getRole());
                user.setContactNum(newUserDetails.getContactNum());
                user.setPosition(newUserDetails.getPosition());
                user.setPassword(newUserDetails.getPassword());
                System.out.println("User " + user.getFname() + " " + user.getLname() + " is updated");
            } catch (NoSuchElementException ex){
                throw new NoSuchElementException("User " + userID + " not found.");
            } finally {
                return userRepo.save(user);
                
            }
            
        }

    //Edit Profile
        public void updateUser(int userID, String contactNum, String password, MultipartFile profileImage) {
        UserEntity user = userRepo.findById(userID).orElseThrow(() -> new RuntimeException("User not found"));
        if (contactNum != null) {
            user.setContactNum(contactNum);
        }

        if (password != null) {
            user.setPassword(password);
        }

        // Check if profileImage is not null and has content
        if (profileImage != null && !profileImage.isEmpty()) {
            try {
                byte[] imageBytes = profileImage.getBytes();
                System.out.println("Received image bytes: " + imageBytes.length);
                user.setProfileImage(imageBytes);
                System.out.println("Received data: " + userID + ", " + contactNum + ", " + password + ", " + profileImage);
            } catch (IOException e) {
                throw new RuntimeException("Error processing profile image", e);
            }
        }
        
      userRepo.save(user);
    }
        //Delete a user in the database
        public String deleteUser(int id){
            String msg = "";
            Optional<UserEntity> optionalUser = userRepo.findById(id);

            if(optionalUser.isPresent()){
                UserEntity user = optionalUser.get();
                user.setDeleted(1);
                userRepo.save(user);

                msg = "User " + user.getFname() + " " + user.getLname() + " is deleted";
            } else {
                msg = "User not found";
            }

            return msg;
        }





    public UserEntity getUserById(int id) {
        return userRepo.findById(id).get();
    }
    //-------------------------------------------------------------------------
    public int getUserIDByEmail(String email) {
        UserEntity user = userRepo.findByEmail(email);

        if (user != null) {
            return user.getUserID();
        } else {
            return -1;
        }
    }


public String getUserNameByEmail(String email) {
        UserEntity user = userRepo.findByEmail(email);
        String fullName;

        if(user != null){
            fullName = user.getFname() + " " +user.getLname();
            return fullName;
        } else {
            return null;
        }
    }

public String getRoleByEmail(String email){
        UserEntity user = userRepo.findByEmail(email);
        String role;

        if(user != null){
            role = user.getRole();
            return role;
        } else {
            return null;
        }
    }


    }


        /*public void updateUser(int userID, String contactNum, String password, MultipartFile profileImage) {
    // Fetch the user from the database
    UserEntity user = userRepo.findById(userID)
            .orElseThrow(() -> new RuntimeException("User not found"));

    // Update user details
    if (profileImage != null && !profileImage.isEmpty()) {
        try {
            // Set the new profile image data
            user.setProfileImage(profileImage.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error processing profile image", e);
        }
    }

        if (contactNum != null) {
            user.setContactNum(contactNum);
        }

        if (password != null) {
            user.setPassword(password);
        }
    // Save the updated user to the database
    userRepo.save(user);
} */       