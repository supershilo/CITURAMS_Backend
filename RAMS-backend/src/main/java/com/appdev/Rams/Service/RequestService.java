package com.appdev.Rams.Service;

import com.appdev.Rams.Entity.RequestEntity;
import com.appdev.Rams.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    RequestRepository requestRepo;

    //Create new request
    public RequestEntity createRequest(RequestEntity request){
        return requestRepo.save(request);
    }

    //Read all ongoing request
    public List<RequestEntity> getAllOngoingRequest(){
        return requestRepo.getAllOngoingRequest();
    }

    //Read all resolved request
    public List<RequestEntity> getAllResolvedRequest(){
        return requestRepo.getAllResolvedRequest();
    }

    //get all request
    public List<RequestEntity> getAllRequest() {
        return requestRepo.findAllRequest();
    }

    //get request by id
    public RequestEntity getRequestByID(int id) {
        Optional<RequestEntity> request = requestRepo.findById(id);

        return request.orElse(null);
    }


    //update
    @SuppressWarnings("finally")
    public RequestEntity updateRequest(int id, RequestEntity newRequestDetails){
        RequestEntity request = new RequestEntity();

        try{
            request = requestRepo.findById(id).get();
            request.setUserName(newRequestDetails.getUserName());
            request.setBuilding(newRequestDetails.getBuilding());
            request.setRoom(newRequestDetails.getRoom());
            request.setEquipment(newRequestDetails.getEquipment());
            request.setMessage(newRequestDetails.getMessage());
            request.setStatus(newRequestDetails.getStatus());
            request.setStaff(newRequestDetails.getStaff());
            request.setDate(newRequestDetails.getDate());
            request.setRemarksDateTime(newRequestDetails.getRemarksDateTime());
            request.setAdminName(newRequestDetails.getAdminName());
            request.setRemarksMsg(newRequestDetails.getRemarksMsg());
            request.setRemarked(newRequestDetails.isRemarked());
            request.setIsDeleted(newRequestDetails.getIsDeleted());
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException("Request " + id + " not found.");
        } finally {
            return requestRepo.save(request);
        }
    }

    //delete
    public String deleteRequest(int id){
        String msg = "";
        Optional<RequestEntity> optionalRequest = requestRepo.findById(id);

        if(optionalRequest.isPresent()){
            RequestEntity request = optionalRequest.get();
            request.setIsDeleted(1);
            requestRepo.save(request);

            msg = "Request " + id + " successfully deleted";
        } else {
            msg = "Request not found";
        }

        return msg;
    }


}
