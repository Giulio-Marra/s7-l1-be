package giulio_marra.s7_l1_be.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobaclExceptionhandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorsPayload> handleBadRequestException(BadRequestException ex) {
        ErrorsPayload errorPayload = new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorPayload, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    // Questo metodo dovrà rispondere con 401
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorsPayload handleUnauthorized(UnauthorizedException ex) {
        return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }
}
