package Java_Exceptions.HomeWork.HW3;

public class DataFormatExceptions {

    public static class IncorrectDataCountException extends Exception {
        public IncorrectDataCountException(String message) {
            super(message);
        }
    }

    public static class IncorrectDateFormatException extends Exception {
        public IncorrectDateFormatException(String message) {
            super(message);
        }
    }

    public static class IncorrectPhoneNumberFormatException extends Exception {
        public IncorrectPhoneNumberFormatException(String message) {
            super(message);
        }
    }

    public static class IncorrectGenderFormatException extends Exception {
        public IncorrectGenderFormatException(String message) {
            super(message);
        }
    }
    
    public static class IncorrectNameSurnamePatronymicException extends Exception {
        public IncorrectNameSurnamePatronymicException(String message) {
            super(message);
        }
    }

    public static class IncorrectFileNameFormatException extends Exception {
        public IncorrectFileNameFormatException(String message) {
            super(message);
        }
    }

    
}
