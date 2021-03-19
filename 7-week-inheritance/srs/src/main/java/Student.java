import java.time.LocalDate;

public class Student extends Person {

    private double gpa;

    public Student(String name, LocalDate birthDate, double gpa) {
        super(name, birthDate);

        this.gpa = gpa;
    }

    public void printLastName() {
        System.out.println(this.lastName);
    }

    public boolean isApproved() {
        return this.gpa >= 3;
    }

    @Override
    public int getAge() {
        return 0;
    }

}


