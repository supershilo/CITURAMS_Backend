package com.appdev.Rams.Service;

import com.appdev.Rams.Entity.BuildingEntity;
import com.appdev.Rams.Repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BuildingService {
	@Autowired
	BuildingRepository brepo;
	
	public BuildingEntity createBldg(BuildingEntity building) {
		return brepo.save(building);
	}
	
	public List<BuildingEntity> getAllBuildings(){
		return brepo.findAllBuilding();
	}


    public String getBuildingNameByID(int id){
        BuildingEntity building = brepo.findById(id).orElseThrow(
                () -> new NoSuchElementException("Building with ID " + id + " not found.")
        );
        return building.getBuildingName();

    }


	
	@SuppressWarnings("finally")
    public BuildingEntity updateBuilding(int id, BuildingEntity newBldg){
        BuildingEntity bldg = new BuildingEntity();

        try{
            //Search user id
            bldg = brepo.findById(id).get();
            //assigning new data to the user entity
            bldg.setBuildingName(newBldg.getBuildingName());
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException("Building " + id + " not found.");
        } finally {
            return brepo.save(bldg);
        }

    }
	
	public String deleteBuilding(int id) {
		String msg = "";
		Optional<BuildingEntity> building = brepo.findById(id);

        if (building.isPresent()) {
            BuildingEntity bldg = building.get();
            bldg.setDeleted(1);
            brepo.save(bldg);
            msg = bldg.getBuildingName() +" Building" +  " is successfully deleted.";
        } else {
            msg = "Invalid Request, Building not found.";
        }

        return msg;
	}

}
