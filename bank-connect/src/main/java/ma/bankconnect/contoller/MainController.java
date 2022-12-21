package ma.bankconnect.contoller;

import ma.bankconnect.entities.Agent;
import ma.bankconnect.error.exception.agent.AgentNotFoundException;
import ma.bankconnect.service.agent.AgentService;
import ma.bankconnect.service.agent.AgentServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private AgentServiceImp agentServiceImp;

    public MainController(AgentServiceImp agentServiceImp) {
        this.agentServiceImp = agentServiceImp;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to BankConnect";
    }

    @GetMapping("/agent/{email}")
    public ResponseEntity<Agent> test(@PathVariable("email") String email) throws AgentNotFoundException {
        Agent agent = agentServiceImp.getAgentByEmail(email);
        if (agent == null) {
            throw new AgentNotFoundException("Agent not found");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(agent);
    }

}