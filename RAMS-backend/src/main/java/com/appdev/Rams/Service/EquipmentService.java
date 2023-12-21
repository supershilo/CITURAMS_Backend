package com.appdev.Rams.Service;

import com.appdev.Rams.Entity.EquipmentEntity;
import com.appdev.Rams.Repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EquipmentService {
    @Autowired
    EquipmentRepository equipmentRepo;

    //create
    public EquipmentEntity createEquipment(EquipmentEntity equipment){
        return equipmentRepo.save(equipment);
    }

    //read
    public List<EquipmentEntity> getAllEquipment(){
        return equipmentRepo.getAllEquipment();
    }

    public EquipmentEntity getEquipmentByID(int id){
        Optional <EquipmentEntity> eqpt = equipmentRepo.findById(id);

        return eqpt.orElse(null);
    }


    //update
    @SuppressWarnings("finally")
    public EquipmentEntity updateEquipment(int id, EquipmentEntity newEquipmentDetails){
        EquipmentEntity equipment = new EquipmentEntity();
        try{
            equipment = equipmentRepo.findById(id).get();
            equipment.setEquipmentName(newEquipmentDetails.getEquipmentName());
            equipment.setIsDeleted(newEquipmentDetails.getIsDeleted());
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException("Equipment " + id + " not found.");
        } finally {
            return equipmentRepo.save(equipment);
        }
    }

    //delete
    public String deleteEquipment(int id){
        String msg = "";
        Optional<EquipmentEntity> optionalEquipment = equipmentRepo.findById(id);

        if(optionalEquipment.isPresent()){
            EquipmentEntity equipment = optionalEquipment.get();
            equipment.setIsDeleted(1);
            equipmentRepo.save(equipment);

            msg = "Equipment " + id + " successfully deleted";
        } else {
            msg = "Equipment not found";
        }

        return msg;
    }




}
