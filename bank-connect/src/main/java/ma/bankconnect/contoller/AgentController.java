package ma.bankconnect.contoller;


import lombok.RequiredArgsConstructor;
import ma.bankconnect.dto.AccountRequest;
import ma.bankconnect.entities.Account;
import ma.bankconnect.entities.Client;
import ma.bankconnect.error.exception.client.ClientNotFoundException;
import ma.bankconnect.service.account.AccountService;
import ma.bankconnect.service.client.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/agent/")
@RequiredArgsConstructor
public class AgentController {

    private final ClientService clientService;
    private final AccountService accountService;

    @PostMapping
    @RequestMapping("account")
    public ResponseEntity<Map<String, String>> addAccount(@RequestBody AccountRequest accountRequest) throws ClientNotFoundException{
        Client client = clientService
                .getClientByEmail(accountRequest.getEmail())
                .orElseThrow(() -> new ClientNotFoundException("Client with this email not found!"));

        Account account = new Account();
        account.setClient(client);
        account.setSolde(0);
        account.setRib(generateRIB());

        accountService.saveAccount(account);

        Map<String, String> response = new HashMap<>();
        response.put("RIB", account.getRib());

        return ResponseEntity.ok(response);
    }

    public String generateRIB() {
        return String.valueOf((long) (Math.random() * 100000000000000L));
    }
}
