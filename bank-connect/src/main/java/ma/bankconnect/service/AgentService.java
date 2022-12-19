package ma.bankconnect.service;


import ma.bankconnect.entities.Agent;

import java.util.Optional;

public interface AgentService {
    Optional<Agent> getAgentByEmail(String email);
}
