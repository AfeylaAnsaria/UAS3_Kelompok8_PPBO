package main.java;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("Password tidak valid!");
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
}