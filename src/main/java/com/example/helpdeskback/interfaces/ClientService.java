package com.example.helpdeskback.interfaces;

import com.example.helpdeskback.entity.Client;
import java.util.*;

public interface ClientService {
    Client addClient(Client client);
    Client getClientById(Long id);
    List<Client> getAllClients();
    Client updateClient(Long id, Client clientDetails);
    void deleteClient(Long id);
}
