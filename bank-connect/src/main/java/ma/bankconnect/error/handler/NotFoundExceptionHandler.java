package ma.bankconnect.error.handler;


import ma.bankconnect.dto.ErrorMessage;
import ma.bankconnect.error.exception.NotFoundException;
import ma.bankconnect.error.exception.account.AccountNotFoundException;
import ma.bankconnect.error.exception.agent.AgentNotFoundException;
import ma.bankconnect.error.exception.archive_account.ArchiveAccountNotFoundException;
import ma.bankconnect.error.exception.archive_client.ArchiveClientNotFoundException;
import ma.bankconnect.error.exception.client.ClientNotFoundException;
import ma.bankconnect.error.exception.transaction.TransactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class NotFoundExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> notFoundException(NotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage()));
    }



}
