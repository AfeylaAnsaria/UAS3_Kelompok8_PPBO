# Flowchart

```mermaid
classDiagram
    direction LR

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

    class InvalidUserException
    class InvalidPasswordException

    class LoginServer {
        - registeredUser: Users <<static>>
        - auth: Auth <<static>>
        + main(args: String[])
    }

    class main {
        + main(args: String[])
    }

    class StaticFileHandler {
        + handle(exchange)
    }

    class LoginHandler {
        + handle(exchange)
        - extractJsonValue(json: String, key: String): String
    }

    %% Relationships
    Auth --> Users : uses
    LoginServer o-- Users : registeredUser
    LoginServer o-- Auth : auth
    LoginServer ..> StaticFileHandler : creates
    LoginServer ..> LoginHandler : creates
    LoginHandler --> Auth : calls login(...)
