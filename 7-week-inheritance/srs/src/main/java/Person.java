import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String name;
    protected String lastName;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

}
