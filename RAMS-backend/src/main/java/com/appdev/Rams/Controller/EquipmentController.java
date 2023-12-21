package com.appdev.Rams.Controller;

import com.appdev.Rams.Entity.EquipmentEntity;
import com.appdev.Rams.Service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
@CrossOrigin(origins = "http://localhost:3000")
public class EquipmentController {
    @Autowired
    EquipmentService equipmentServ;

    @PostMapping("/createEquipment")
    public EquipmentEntity createEquipment(@RequestBody EquipmentEntity equipment){
        return equipmentServ.createEquipment(equipment);
    }

    @GetMapping("/getAllEquipment")
    public List<EquipmentEntity> getAllEquipment(){
        return equipmentServ.getAllEquipment();
    }

    @GetMapping("/getEquipment/{id}")
    public ResponseEntity<EquipmentEntity> getEquipmentByID(@PathVariable int id){
        EquipmentEntity eqpt = equipmentServ.getEquipmentByID(id);

        if(eqpt != null){
            return ResponseEntity.ok(eqpt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/updateEquipment")
    public EquipmentEntity updateEquipment(@RequestParam int id, @RequestBody EquipmentEntity newEquipmentDetails){
        return equipmentServ.updateEquipment(id, newEquipmentDetails);
    }

    @DeleteMapping("/deleteEquipment/{id}")
    public String deleteEquipment(@PathVariable int id){
        return equipmentServ.deleteEquipment(id);
    }


}
