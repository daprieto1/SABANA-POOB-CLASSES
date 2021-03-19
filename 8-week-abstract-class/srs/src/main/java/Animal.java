/**
 * Class that represents an animal.
 */
public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    /**
     * Reproduce the animal sound.
     */
    abstract public String greeting();

    public String sayName() {
        String greeting = greeting();
        return String.format("%s, my name is %s", greeting, this.name);
    }

    public final String getBreed() {
        return "This animal is a " + this.getClass().getSimpleName();
    }

    public String getName() {
        return name;
    }
}


