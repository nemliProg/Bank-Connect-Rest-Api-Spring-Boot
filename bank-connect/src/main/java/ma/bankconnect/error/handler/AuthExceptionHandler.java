package ma.bankconnect.error.handler;


import ma.bankconnect.dto.ErrorMessage;
import ma.bankconnect.error.exception.LoginFailedException;
import ma.bankconnect.error.exception.client.ClientRegisterFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class AuthExceptionHandler {

    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<ErrorMessage> loginFailed(LoginFailedException exception) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ErrorMessage(HttpStatus.FORBIDDEN, exception.getMessage()));
    }

    @ExceptionHandler(ClientRegisterFailedException.class)
    public ResponseEntity<ErrorMessage> clientRegisterFailed(ClientRegisterFailedException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

}
