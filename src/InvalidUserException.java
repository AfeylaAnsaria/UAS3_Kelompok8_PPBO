class UserInvalidException extends Exception {
    public UserInvalidException() {
        super("Username tidak valid!");
    }
    
    public UserInvalidException(String message) {
        super(message);
    }
}