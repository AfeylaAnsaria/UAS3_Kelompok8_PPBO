package main.java;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Buat user yang terdaftar (hardcoded untuk testing)
        Users registeredUser = new Users("admin", "admin123");
        
        // Buat object Auth dengan user yang terdaftar
        Auth auth = new Auth(registeredUser);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEM LOGIN ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        try {
            auth.login(username, password);
            System.out.println("Welcome, " + username + "!");
        } catch (InvalidUserException e) {
            System.out.println("Login failed: " + e.getMessage());
        } catch (InvalidPasswordException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        
        scanner.close();
    }
}