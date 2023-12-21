package com.appdev.Rams.Service;

import com.appdev.Rams.Entity.DepartmentEntity;
import com.appdev.Rams.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository deptRepo;
	
	public DepartmentEntity createDept(DepartmentEntity dept) {
		return deptRepo.save(dept);
	}
	
	public List<DepartmentEntity> getAllDepts(){
        return deptRepo.findAllDepts();
    }

    //Update a user record in the database
    @SuppressWarnings("finally")
    public DepartmentEntity updateDept(int id, DepartmentEntity newDept){
        DepartmentEntity dept = new DepartmentEntity();

        try{
            //Search user id
            dept = deptRepo.findById(id).get();
            //assigning new data to the user entity
            dept.setDeptName(newDept.getDeptName());
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException("Department " + id + " not found.");
        } finally {
            return deptRepo.save(dept);
        }

    }

    //Delete a user in the database
    public String deleteDept(int id){
        String msg = "";
        Optional<DepartmentEntity> optionalDepartment = deptRepo.findById(id);

        if(optionalDepartment.isPresent()){
            DepartmentEntity dept = optionalDepartment.get();
            dept.setDeleted(1);
            deptRepo.save(dept);

            msg = dept.getDeptName() + " " + "Building " + "has been deleted.";
        } else {
            msg = "Invalid Request, Building not found.";
        }

        return msg;
    }
	
	

}
