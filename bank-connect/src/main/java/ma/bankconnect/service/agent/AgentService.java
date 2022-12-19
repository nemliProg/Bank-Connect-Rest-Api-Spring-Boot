package ma.bankconnect.service.agent;


import ma.bankconnect.entities.Agent;

import java.util.Optional;

public interface AgentService {
    Optional<Agent> getAgentByEmail(String email);
}
