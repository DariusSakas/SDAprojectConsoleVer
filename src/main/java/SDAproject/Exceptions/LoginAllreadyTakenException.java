package SDAproject.Exceptions;

public class LoginAllreadyTakenException extends Exception{

    public LoginAllreadyTakenException() {
        System.out.println("Login already taken. Try another one!");
    }

}
