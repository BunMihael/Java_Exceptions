package Java_Exceptions.HomeWork.HW2;

import java.util.Scanner;

class EmptyStringException extends RuntimeException {
    public EmptyStringException(String message) {
        super(message);
    }
}

public class EmptyString {
    public static String requestString() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter a non-empty string: ");
            userInput = scanner.nextLine().trim();
            if (userInput.isEmpty()) {
                throw new EmptyStringException("Empty strings are not allowed.");
            } else {
                validInput = true;
            }
        }

        return userInput;
    }

    public static void main(String[] args) {
        try {
            String userString = requestString();
            System.out.println("You entered: " + userString);
        } catch (EmptyStringException e) {
            System.out.println(e.getMessage());
        }
    }
}
