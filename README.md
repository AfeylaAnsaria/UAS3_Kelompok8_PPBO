```mermaid
classDiagram
    direction TB

    class Users {
        - username: String
        - password: String
        + Users(username: String, password: String)
        + getUsername(): String
        + getPassword(): String
    }

    class Auth {
        - userRegistered: Users
        + Auth(userRegistered: Users)
        + login(userName: String, password: String) 
    }

    class Exception {
        <<Java Built-in>>
    }

    class InvalidUserException {
        + InvalidUserException()
        + InvalidUserException(message: String)
    }

    class InvalidPasswordException {
        + InvalidPasswordException()
        + InvalidPasswordException(message: String)
    }

    class LoginServer {
        - registeredUser: Users <<static>>
        - auth: Auth <<static>>
        + main(args: String[]) <<static>>
    }

    class main {
        + main(args: String[]) <<static>>
    }

    class StaticFileHandler {
        <<inner class>>
        + handle(exchange: HttpExchange)
        - getContentType(path: String): String
    }

    class LoginHandler {
        <<inner class>>
        + handle(exchange: HttpExchange)
        - extractJsonValue(json: String, key: String): String
    }

    %% Inheritance
    Exception <|-- InvalidUserException
    Exception <|-- InvalidPasswordException

    %% Composition & Aggregation
    Auth *-- Users : has-a
    LoginServer o-- Users : registeredUser (static)
    LoginServer o-- Auth : auth (static)

    %% Dependencies
    LoginServer ..> StaticFileHandler : contains
    LoginServer ..> LoginHandler : contains
    LoginHandler ..> Auth : calls login()
    Auth ..> InvalidUserException : throws
    Auth ..> InvalidPasswordException : throws
    main ..> Users : creates
    main ..> Auth : creates
    main ..> InvalidUserException : catches
    main ..> InvalidPasswordException : catches

    %% Notes
    note for LoginServer
        "HTTP server on port 8080
        Serves /index.html and /api/login
        Demo: admin/admin123"
