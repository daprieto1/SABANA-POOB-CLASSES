import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnimalTest {

    private static List<Animal> animals;

    @BeforeAll
    public static void setUp() {

        animals = new ArrayList<>();
        animals.add(new Dog("GoodBoy"));
        animals.add(new Cat("LittleKitty"));
        animals.add(new Dog("AMA!!"));
        animals.add(new Cat("Karen"));
    }

    @Test
    public void shouldGreeting() {

        for (Animal animal : animals) {
            assertNotNull(animal.greeting());
        }
    }


}
