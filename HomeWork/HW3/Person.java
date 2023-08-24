package Java_Exceptions.HomeWork.HW3;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    public Person(String surname, String name, String patronymic, String birthDate, long phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender;
    }
}
