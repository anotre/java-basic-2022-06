package net.zaycev.homework.l14;

import java.util.Scanner;

public class Auth {
    public Auth() {}
    // ?
    // private Scanner scanner = new Scanner(System.in)
    public static void authenticateAsUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the login:");
            String login = getUserInput(scanner);
            System.out.println("Enter the password:");
            String password = getUserInput(scanner);

            if (!checkAuthData(login, password)) {
                System.out.println("Login or password is wrong. Please check it and retry.");
            }

        } catch (UserInputAttemptsOverException e) {
            System.out.println("Please, retry the authentication");
            System.exit(1);
        }


    }

    private static boolean checkAuthData(String login, String password) {
        return false;
    }

    private static String getUserInput(Scanner scanner) throws UserInputAttemptsOverException {
        final int MAX_ATTEMPTS_NUMBER = 3;
        String userInput = "";

        try {
            for (int i = 0; i < MAX_ATTEMPTS_NUMBER; i++) {
                try {
                    userInput = scanner.nextLine();
                    if (userInput.isEmpty()) {
                        throw new EmptyStringException();
                    }
                    break;
                } catch (EmptyStringException e) {}
            }
            if (userInput.isEmpty()) {
                throw new UserInputAttemptsOverException();
            }
        } catch (UserInputAttemptsOverException e) {
            throw e;
        }

        return userInput;
    }
}
