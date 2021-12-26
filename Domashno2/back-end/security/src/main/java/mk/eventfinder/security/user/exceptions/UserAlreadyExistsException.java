package mk.eventfinder.security.user.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String usernameOrEmail) {
        System.out.printf("User with this %s already exists%n", usernameOrEmail);
    }

}
