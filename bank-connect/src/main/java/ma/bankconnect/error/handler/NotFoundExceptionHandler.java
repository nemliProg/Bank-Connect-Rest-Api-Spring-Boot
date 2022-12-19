package ma.bankconnect.error.handler;


import ma.bankconnect.dto.ErrorMessage;
import ma.bankconnect.error.exception.ArchiveClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(ArchiveClientNotFoundException.class)
    public ResponseEntity<ErrorMessage> archiveClientNotFound(ArchiveClientNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
