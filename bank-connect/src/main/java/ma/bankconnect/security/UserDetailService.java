package ma.bankconnect.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.bankconnect.entities.Agent;
import ma.bankconnect.entities.Client;
import ma.bankconnect.repository.AgentRepository;
import ma.bankconnect.repository.ClientRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailService implements UserDetailsService {

    final AgentRepository agentRepository;

    final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String emailAndType) throws UsernameNotFoundException {
        log.info("Inside UserDetailService for user {}", emailAndType);
        String email    = emailAndType.split(":")[0];
        String type     = emailAndType.split(":")[1];

        switch (type) {
            case "client" -> {
                Client client = clientRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Client not found"));
                return new User(email, client.getPassword(), Collections.singleton(new SimpleGrantedAuthority("CLIENT")));
            }
            case "agent" -> {
                Agent agent = agentRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Agent not found"));
                return new User(email, agent.getPassword(), Collections.singleton(new SimpleGrantedAuthority("AGENT")));
            }
            default -> throw new UsernameNotFoundException("User not found");
        }
    }
}
