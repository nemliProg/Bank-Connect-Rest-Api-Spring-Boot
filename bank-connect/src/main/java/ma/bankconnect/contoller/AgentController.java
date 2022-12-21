package ma.bankconnect.contoller;


import ma.bankconnect.entities.Agent;
import ma.bankconnect.error.exception.agent.AgentNotFoundException;
import ma.bankconnect.service.agent.AgentServiceImp;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private AgentServiceImp agentServiceImp;

    public AgentController(AgentServiceImp agentServiceImp) {
        this.agentServiceImp = agentServiceImp;
    }

    @PostMapping("/get")
    EntityModel<Agent> getAgentByEmail(@RequestBody String email) throws AgentNotFoundException {
        Agent agent = agentServiceImp.getAgentByEmail(email);
        return EntityModel.of(agent, //
                linkTo(methodOn(AgentController.class).getAgentByEmail(email)).withSelfRel());
    }



}
