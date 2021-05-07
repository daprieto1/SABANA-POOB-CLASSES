import java.time.LocalDate;

public class Dog extends Animal implements IPet, Comparable<Dog> {

    private int size;
    private LocalDate birthDate;

    public Dog(String name) {
        super(name);
    }

    @Override
    public String greeting() {
        return "Wof Wof!!!";
    }


    @Override
    public boolean roll() {
        return true;
    }

    @Override
    public String sayLoveYourMaster(String masterName) {
        return String.format("I love my master %s", masterName);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public int compareTo(Dog o) {
        return this.birthDate.compareTo(o.getBirthDate());
    }
}
