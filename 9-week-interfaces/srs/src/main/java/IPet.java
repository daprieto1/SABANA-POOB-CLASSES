public interface IPet {

    boolean EAT = true;

    boolean roll();

    String sayLoveYourMaster(String masterName);

    default boolean eat() {
        System.out.println("Off course I'm gonna eat, it is my unique job here.");
        return IPet.EAT;
    }

}
