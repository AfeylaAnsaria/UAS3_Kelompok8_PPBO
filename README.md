```mermaid
classDiagram 
    class Main {
        +main(String[] args)
    }
    
    class Users {
        -String username
        -String password
        +Users(String userName, String password)
        +getUsername() String
        +getPassword() String
    }
    
    class Auth {
        -Users userRegistered
        +Auth(Users userRegistered)
        +login(String userName, String password)
    }
    
    class InvalidUserException {
        +InvalidUserException(String message)
    }
    
    class InvalidPasswordException {
        +InvalidPasswordException(String message)
    }

    
    Main ..> Users : creates
    Main ..> Auth : creates
    Main ..> InvalidUserException : catches
    Main ..> InvalidPasswordException : catches
    
    Auth --> Users : uses
    Auth ..> InvalidUserException : throws
    Auth ..> InvalidPasswordException : throws

