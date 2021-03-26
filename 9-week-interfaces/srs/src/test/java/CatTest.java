import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {

    private static Cat cat;

    @BeforeAll
    public static void setUp() {
        cat = new Cat("GoodBoy");
    }

    @Test
    public void shouldGreeting() {

        String greeting = cat.greeting();
        assertEquals("Miau mIAU", greeting);
    }

    @Test
    public void shouldSayName() {

        String name = cat.sayName();
        assertEquals("Miau mIAU, my name is GoodBoy", name);
    }

    @Test
    public void shouldGetBreed() {

        String breed = cat.getBreed();
        assertEquals("This animal is a Cat", breed);
    }

}
