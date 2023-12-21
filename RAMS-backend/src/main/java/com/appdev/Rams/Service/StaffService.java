package com.appdev.Rams.Service;

import com.appdev.Rams.Entity.StaffEntity;
import com.appdev.Rams.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StaffService {
	@Autowired
	StaffRepository staffRepo;
	
	public StaffEntity createStaff(StaffEntity staff) {
		return staffRepo.save(staff);
	}
	
	public List<StaffEntity> getAllStaff(){
        return staffRepo.getAllStaff();
    }

    //Update a user record in the database
    @SuppressWarnings("finally")
    public StaffEntity updateStaff(int id, StaffEntity newStaffDetails){
        StaffEntity staff = new StaffEntity();

        try{
            //Search user id
            staff = staffRepo.findById(id).get();
            //assigning new data to the user entity
            staff.setFname(newStaffDetails.getFname());
            staff.setLname(newStaffDetails.getLname());
            staff.setEmail(newStaffDetails.getEmail());
            staff.setStatus(newStaffDetails.getStatus());
            staff.setContactNum(newStaffDetails.getContactNum());
            staff.setIsDeleted(newStaffDetails.getIsDeleted());
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException("Staff " + id + " not found.");
        } finally {
            return staffRepo.save(staff);
        }

    }

    //Delete a staff in the database
    public String deleteStaff(int id){
        String msg = "";
        Optional<StaffEntity> optionalStaff = staffRepo.findById(id);

        if(optionalStaff.isPresent()){
            StaffEntity staff = optionalStaff.get();
            staff.setIsDeleted(1);
            staffRepo.save(staff);

            msg = staff.getFname() + " " + staff.getLname() + " " + "Staff " + "has been deleted.";
        } else {
            msg = "Invalid Request, Staff not found.";
        }

        return msg;
    }
	
	

}
