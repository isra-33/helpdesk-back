package com.example.helpdeskback.service;

import com.example.helpdeskback.entity.*;
import com.example.helpdeskback.interfaces.ComplaintService;
import com.example.helpdeskback.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public Complaint addComplaint(Complaint complaint) {
        complaint.setCreationDate(new Date());
        return complaintRepository.save(complaint) ;
    }

    @Override
    public Complaint updateComplaint(Long id, Complaint complaintDetails) {
        Complaint complaint = complaintRepository.findById(id).orElse(null);
        if (complaintDetails != null) {
            complaint.setTitle(complaintDetails.getTitle());
            complaint.setCreationDate(complaintDetails.getCreationDate());

            complaint.setStatus(complaintDetails.getStatus());
            complaint.setAgent(complaintDetails.getAgent());
            complaint.setClient(complaintDetails.getClient());
        }
        return complaint;
    }

    @Override
    public void deleteComplaint(Long id) {
        complaintRepository.findById(id).ifPresent(
                complaint -> complaintRepository.delete(complaint)
        );
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).orElse(null);
    }
}
