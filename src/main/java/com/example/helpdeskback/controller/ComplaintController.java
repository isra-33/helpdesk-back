package com.example.helpdeskback.controller;

import com.example.helpdeskback.entity.Complaint;
import com.example.helpdeskback.interfaces.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return complaintService.addComplaint(complaint);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Complaint getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public Complaint updateComplaint(@PathVariable Long id, @RequestBody Complaint complaintDetails) {
        return complaintService.updateComplaint(id, complaintDetails);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
    }
}
