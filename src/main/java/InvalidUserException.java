package main.java;

public class InvalidUserException extends Exception {
    public InvalidUserException() {
        super("Username tidak valid!");
    }

    public InvalidUserException(String message) {
        super(message);
    }
}