package com.example.helpdeskback.controller;



import com.example.helpdeskback.enums.Status;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatusController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/status")
    public Status[] getStatus() {
        return Status.values();
    }
}
