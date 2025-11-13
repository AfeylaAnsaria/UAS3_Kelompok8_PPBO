package main.java;

public class Auth {
    private Users userRegistered;

    public Auth(Users userRegistered) {
        this.userRegistered = userRegistered;
    }

    public void login(String userName, String password) throws InvalidUserException, InvalidPasswordException {
        // Cek username dulu
        if (!userRegistered.getUsername().equals(userName)) {
            throw new InvalidUserException("Invalid username: " + userName);
        }
        
        // Baru cek password
        if (!userRegistered.getPassword().equals(password)) {
            throw new InvalidPasswordException("Invalid password for user: " + userName);
        }
        
        System.out.println("Login successful for user: " + userName);
    }
}