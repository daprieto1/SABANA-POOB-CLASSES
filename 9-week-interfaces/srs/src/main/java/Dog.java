public class Dog extends Animal implements IPet {

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
}
