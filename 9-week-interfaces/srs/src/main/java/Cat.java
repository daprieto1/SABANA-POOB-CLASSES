public class Cat extends Animal implements IPet{

    public Cat(String name) {
        super(name);
    }

    @Override
    public String greeting() {
        return "Miau mIAU";
    }
}
