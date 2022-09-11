package main.javaspring.exceptions;

public class ModelNotFoundException extends Throwable {

    public ModelNotFoundException(String message, Long id) {
        super(message + id);
    }
}
