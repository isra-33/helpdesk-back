package com.example.helpdeskback.repository;

import com.example.helpdeskback.entity.Agent;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {
    Optional<Agent> findByAgentEmail(String agentEmail);

}
