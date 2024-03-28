package matsa.dev.desafiouolhost.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionDTO> handNoSuchElementException(NoSuchElementException exception) {
        ExceptionDTO dto = new ExceptionDTO("There are no more codenames avaliable.", "400");

        return ResponseEntity.badRequest().body(dto);
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handPlayerNotFoundException(PlayerNotFoundException exception) {
        ExceptionDTO dto = new ExceptionDTO(exception.getMessage(), "404");

        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status).body(dto);
    }
}
