package com.example.helpdeskback.interfaces;

import com.example.helpdeskback.entity.Complaint;

import java.util.*;

public interface ComplaintService {

    Complaint addComplaint(Complaint complaint);
    Complaint updateComplaint(Long id, Complaint complaintDetails);
    //Complaint statusComplaint(Long id);
    void deleteComplaint(Long id);
    List<Complaint> getAllComplaints();
    Complaint getComplaintById(Long id);

}
