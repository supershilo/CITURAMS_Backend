package com.appdev.Rams.Service;

import com.appdev.Rams.Entity.AdminEntity;
import com.appdev.Rams.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepo;

    //Create admin account
    public AdminEntity createAdmin(AdminEntity admin){
        return adminRepo.save(admin);
    }

    //Read all admin acc
    public List<AdminEntity> getAllAdmin(){
        return adminRepo.findAllAdmin();
    }

    //Update Admin
    @SuppressWarnings("finally")
    public AdminEntity updateAdmin(int id, AdminEntity newAdminDetails){
        AdminEntity admin = new AdminEntity();

        try{
            admin = adminRepo.findById(id).get();
            admin.setFname(newAdminDetails.getFname());
            admin.setLname(newAdminDetails.getLname());
            admin.setEmail(newAdminDetails.getEmail());
            admin.setPassword(newAdminDetails.getPassword());
            admin.setDepartment(newAdminDetails.getDepartment());
            admin.setPosition(newAdminDetails.getPosition());
            admin.setRole(newAdminDetails.getRole());
            admin.setContactNum(newAdminDetails.getContactNum());
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException("User " + id + " not found.");
        } finally {
            return adminRepo.save(admin);
        }

    }

    //Delete Admin
    public String deleteAdmin(int id){
        String msg = "";
        Optional<AdminEntity> optionalAdmin = adminRepo.findById(id);

        if(optionalAdmin.isPresent()){
            AdminEntity admin = optionalAdmin.get();
            admin.setIsDeleted(1);
            adminRepo.save(admin);

            msg = "User " + admin.getFname() + " " + admin.getLname() + " is deleted";
        } else{
            msg = "Admin not found";
        }

        return msg;
    }
   
}
