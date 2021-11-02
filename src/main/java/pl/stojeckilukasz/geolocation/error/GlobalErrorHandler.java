package pl.stojeckilukasz.geolocation.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.stojeckilukasz.geolocation.exception.ConflictException;
import pl.stojeckilukasz.geolocation.exception.NotFoundException;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = ConflictException.class)
    public ResponseEntity<Object> handleEntityExists(ConflictException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorDetails(e.getMessage()));
    }


    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDetails(e.getMessage()));
    }


}
