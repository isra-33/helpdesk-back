package com.example.helpdeskback.controller;


import com.example.helpdeskback.entity.Client;
import com.example.helpdeskback.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    public Client createClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        return clientService.updateClient(id, clientDetails);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
