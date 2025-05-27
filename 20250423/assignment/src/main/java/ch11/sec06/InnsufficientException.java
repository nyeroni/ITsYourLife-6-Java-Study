package ch11.sec06;

public class InnsufficientException extends Exception {
    public InnsufficientException() {}
    public InnsufficientException(String message) {
        super(message);
    }
}
