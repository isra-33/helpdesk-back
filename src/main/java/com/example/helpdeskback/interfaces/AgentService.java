package com.example.helpdeskback.interfaces;

import com.example.helpdeskback.entity.Agent;
import org.springframework.stereotype.Service;

import java.util.*;

public interface AgentService {

    Agent addAgent(Agent agent);
    Agent getAgentById(Long id);
    List<Agent> getAllAgents();
    Agent updateAgent(Long id, Agent agentDetails);
    void deleteAgent(Long id);
}
