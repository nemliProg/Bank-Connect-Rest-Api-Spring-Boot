package ma.bankconnect.contoller;


import lombok.RequiredArgsConstructor;
import ma.bankconnect.dto.TransactionRequest;
import ma.bankconnect.entities.Account;
import ma.bankconnect.service.account.AccountService;
import ma.bankconnect.service.client.ClientService;
import ma.bankconnect.entities.Client;
import ma.bankconnect.error.exception.client.ClientNotFoundException;
import ma.bankconnect.service.transaction.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<String> transfer(@RequestBody TransactionRequest transactionRequest) throws ClientNotFoundException {
        Account sender = accountService
                .getAccountByRib(transactionRequest.getSender())
                .orElseThrow( () -> new ClientNotFoundException("Sender RIB not found"));

        Account receiver = accountService
                .getAccountByRib(transactionRequest.getReceiver())
                .orElseThrow( () -> new ClientNotFoundException("Receiver RIB not found"));

        if(!accountService.transferMoney(sender, receiver, transactionRequest.getAmount())){
            throw new ClientNotFoundException("Transaction can't occur!");
        }
        return ResponseEntity.ok().body("transaction completed");
    }
}
