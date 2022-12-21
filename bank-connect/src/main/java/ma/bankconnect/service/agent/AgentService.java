package ma.bankconnect.service.agent;


import ma.bankconnect.entities.Agent;
import ma.bankconnect.error.exception.agent.AgentNotFoundException;

import java.util.Optional;

public interface AgentService {
    Agent getAgentByEmail(String email) throws AgentNotFoundException;
}
