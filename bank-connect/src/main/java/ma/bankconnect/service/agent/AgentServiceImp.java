package ma.bankconnect.service.agent;

import ma.bankconnect.entities.Agent;
import ma.bankconnect.repository.AgentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AgentServiceImp implements AgentService {

    private AgentRepository agentRepository;

    public AgentServiceImp(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    public Optional<Agent> getAgentByEmail(String email) {
        return agentRepository.findByEmail(email);
    }
}
