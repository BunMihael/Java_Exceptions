package Java_Exceptions.HomeWork.HW2;

import java.util.Scanner;

public class UserInput {
    public static float requestFloat() {
        Scanner scanner = new Scanner(System.in);
        float userInput = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Please enter a floating-point number: ");
            String inputString = scanner.nextLine();
            if (!inputString.contains(".")) {
                System.out.println("Invalid input. Please enter a floating-point number with a decimal point.");
                continue;
            }
            try {
                userInput = Float.parseFloat(inputString);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid floating-point number.");
            }
        }
        
        return userInput;
    }

    public static void main(String[] args) {
        float userNumber = requestFloat();
        System.out.println("You entered: " + userNumber);
    }
}
