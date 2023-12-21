package com.appdev.Rams.Controller;

import com.appdev.Rams.Entity.RequestEntity;
import com.appdev.Rams.Service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
@CrossOrigin(origins = "http://localhost:3000")
public class RequestController {
    @Autowired
    RequestService reqServ;

    @PostMapping("/createRequest")
    public RequestEntity createRequest(@RequestBody RequestEntity request){
        return reqServ.createRequest(request);
    }

    @GetMapping("/getAllOngoingRequest")
    public List<RequestEntity> getAllOngoingRequest(){
        return reqServ.getAllOngoingRequest();
    }

    @GetMapping("/getAllResolvedRequest")
    public List<RequestEntity> getAllReservedRequest(){
        return reqServ.getAllResolvedRequest();
    }

    @GetMapping("/getAllRequest")
    public List<RequestEntity> getAllRequest(){
        return reqServ.getAllRequest();
    }

    @GetMapping("/getRequest/{id}")
    public ResponseEntity<RequestEntity> getRequestByID(@PathVariable int id){
        RequestEntity request = reqServ.getRequestByID(id);

        if(request != null){
            return ResponseEntity.ok(request);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateRequest")
    public RequestEntity updateRequest(@RequestParam int id, @RequestBody RequestEntity newRequestDetails){
        return reqServ.updateRequest(id, newRequestDetails);
    }

    @DeleteMapping("/deleteRequest/{id}")
    public String deleteRequest(@PathVariable int id){
        return reqServ.deleteRequest(id);
    }




}
