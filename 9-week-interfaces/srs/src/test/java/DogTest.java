import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DogTest {

    private static Dog dog;

    @BeforeAll
    public static void setUp() {
        dog = new Dog("GoodBoy");
    }

    @Test
    public void shouldGreeting() {

        String greeting = dog.greeting();
        assertEquals("Wof Wof!!!", greeting);
    }

    @Test
    public void shouldSayName() {

        String name = dog.sayName();
        assertEquals("Wof Wof!!!, my name is GoodBoy", name);
    }

    @Test
    public void shouldGetBreed() {

        String breed = dog.getBreed();
        assertEquals("This animal is a Dog", breed);
    }

    @Test
    public void shouldRoll() {

        boolean roll = dog.roll();
        assertTrue(roll);
    }

    @Test
    public void shouldLoveMaster() {

        String masterLove = dog.sayLoveYourMaster("Jake");
        assertEquals("I love my master Jake", masterLove);
    }

    @Test
    public void shouldEat() {

        boolean eat = dog.eat();
        assertTrue(eat);
    }

}
