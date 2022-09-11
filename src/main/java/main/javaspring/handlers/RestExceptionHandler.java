package main.javaspring.handlers;

import main.javaspring.exceptions.JsonException;
import main.javaspring.exceptions.ModelNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    protected ResponseEntity<Object> handleModelNotFound(ModelNotFoundException e) {
        JsonException jsonException = new JsonException(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(jsonException, jsonException.getStatus());
    }
}
