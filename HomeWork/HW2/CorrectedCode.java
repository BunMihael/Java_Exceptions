package Java_Exceptions.HomeWork.HW2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CorrectedCode {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scanner = new Scanner(System.in);
        int d = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Please enter a non-zero integer for division: ");
            try {
                d = scanner.nextInt();
                if (d == 0) {
                    System.out.println("Invalid input. Division by zero is not allowed.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); 
            }
        }
        
        try {
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
