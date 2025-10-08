package week3;

public class PasswordValidator {


    public String validate(String username, String password) {

        if (password.isEmpty() || username.isEmpty()) {
            return "Password is empty";
        }
        if (password.length() < 8) {
            return "Password must be at least 8 characters";
        }
        if (password.contains(username)) {
            return "your password must not be same as the username";
        }
        if (!containsAnyOf(password, "1234567890")) {
            return "add a number";
        }
        if (!containsAnyOf(password, "abcdefghijklmnopqrstuvwxyz")) {
            return "add a lower letter";
        }
        if (!containsAnyOf(password, "ABCDEFGHIJKLMNOPQRSTUVWXYZ")) {
            return "add a capitale letter";
        }
        if (!containsAnyOf(password, " []%£&@#€$(){}<>/?+-*\\")) {
            return "add a symbool";
        }

        return "Ok";
    }

    private boolean containsAnyOf(String input, String charsToFind) {
        for (char c : charsToFind.toCharArray()) {
            if (input.indexOf(c) != -1) return true;
        }
        return false;
    }


}
