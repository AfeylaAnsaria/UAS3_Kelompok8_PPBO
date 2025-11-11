import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        SistemOtentikasi sistem = new SistemOtentikasi();
        
        // Menambahkan beberapa user untuk testing
        sistem.tambahUser(new User("admin", "admin123"));
        sistem.tambahUser(new User("user1", "password1"));
        sistem.tambahUser(new User("john", "doe123"));
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEM LOGIN ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        try {
            sistem.login(username, password);
            System.out.println("Login successful! Welcome, " + username);
        } catch (UserInvalidException | PasswordInvalidException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        
        scanner.close();
    }
}
