package ma.bankconnect.service.agent;

import ma.bankconnect.entities.Agent;

import java.util.Optional;

public class AgentServiceImp implements AgentService {

    @Override
    public Optional<Agent> getAgentByEmail(String email) {
        return Optional.empty();
    }
}
