package com.example.helpdeskback.controller;


import com.example.helpdeskback.entity.Agent;
import com.example.helpdeskback.interfaces.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @CrossOrigin()
    @PostMapping("")
    public Agent createAgent(@RequestBody Agent agent) {
        return agentService.addAgent(agent);
    }

    @CrossOrigin()
    @GetMapping("")
    public List<Agent> getAllAgents() {
        return agentService.getAllAgents();
    }

    @CrossOrigin()
    @GetMapping("/{id}")
    public Agent getAgentById(@PathVariable Long id) {
        return agentService.getAgentById(id);
    }

    @CrossOrigin()
    @PutMapping("/{id}")
    public Agent updateAgent(@PathVariable Long id, @RequestBody Agent agentDetails) {
        return agentService.updateAgent(id, agentDetails);
    }

    @CrossOrigin()
    @DeleteMapping("/{id}")
    public void deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
    }
}
