public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String greeting() {
        return "Wof Wof!!!";
    }
}
