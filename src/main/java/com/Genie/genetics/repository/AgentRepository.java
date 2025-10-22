package com.Genie.genetics.repository;

import com.Genie.genetics.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface AgentRepository extends JpaRepository<Agent, Long> {
    Optional<Agent> findByAgentId(String agentId);
}
