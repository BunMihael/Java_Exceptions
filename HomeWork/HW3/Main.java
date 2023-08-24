package Java_Exceptions.HomeWork.HW3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name (use only Latin letters and numbers, without spaces):");
        String fileName = scanner.nextLine().trim();
        try {
            validateFileName(fileName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }

        System.out.println("Now, please enter the data in the following format:");
        System.out.println("Surname Name Patronymic birth_date(in the format dd.mm.yyyy) phone_number(without spaces) gender(m or f)");
        
        boolean continueInput = true;
        while (continueInput) {
            String input = scanner.nextLine();
            
            try {
                Person person = parseInput(input);
                FileHandler.writeToFile(person, fileName + ".txt");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                continue;
            }
            
            System.out.println("Do you want to enter data for another person? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                continueInput = false;
            }
            System.out.println("Please enter the data in the following format:");
        }
    }

    private static void validateFileName(String fileName) throws DataFormatExceptions.IncorrectFileNameFormatException {
        if (!fileName.matches("^[a-zA-Z0-9]+$")) {
            throw new DataFormatExceptions.IncorrectFileNameFormatException("Incorrect file name format. Only Latin letters and numbers are expected.");
        }
    }

    private static Person parseInput(String input) throws Exception {
        String[] parts = input.split("\\s+");

        if (parts.length != 6) {
            throw new DataFormatExceptions.IncorrectDataCountException("Incorrect data count. Expected 6, got " + parts.length);
        }

        validateNameSurnamePatronymic(parts[0], "Surname");
        validateNameSurnamePatronymic(parts[1], "Name");
        validateNameSurnamePatronymic(parts[2], "Patronymic");

        String birthDate = parts[3];
        validateBirthDate(birthDate);

        long phoneNumber = validatePhoneNumber(parts[4]);

        char gender = validateGender(parts[5]);

        return new Person(parts[0], parts[1], parts[2], birthDate, phoneNumber, gender);
    }

    private static void validateNameSurnamePatronymic(String value, String type) throws DataFormatExceptions.IncorrectNameSurnamePatronymicException {
        for (char ch : value.trim().toCharArray()) {
            if (!Character.isLetter(ch) || !String.valueOf(ch).matches("[a-zA-Z]")) {
                throw new DataFormatExceptions.IncorrectNameSurnamePatronymicException("Incorrect format for " + type + ". Only Latin letters are expected.");
            }
        }
    }

    private static void validateBirthDate(String birthDate) throws DataFormatExceptions.IncorrectDateFormatException {
        Pattern pattern = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$");
        Matcher matcher = pattern.matcher(birthDate);
        if (!matcher.matches()) {
            throw new DataFormatExceptions.IncorrectDateFormatException("Incorrect date format.");
        }
    }

    private static long validatePhoneNumber(String phoneNumberString) throws DataFormatExceptions.IncorrectPhoneNumberFormatException {
        try {
            return Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
            throw new DataFormatExceptions.IncorrectPhoneNumberFormatException("Incorrect phone number format.");
        }
    }

    private static char validateGender(String genderString) throws DataFormatExceptions.IncorrectGenderFormatException {
        if (genderString.length() != 1 || (genderString.charAt(0) != 'f' && genderString.charAt(0) != 'm')) {
            throw new DataFormatExceptions.IncorrectGenderFormatException("Incorrect gender format.");
        }
        return genderString.charAt(0);
    }
}
