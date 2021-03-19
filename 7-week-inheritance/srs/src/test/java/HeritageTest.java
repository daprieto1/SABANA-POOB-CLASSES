import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeritageTest {

    @Test
    @DisplayName("Persona Test")
    public void shouldGetAPersonaAge() {

        Person p = new Person("Juan", LocalDate.now().minusDays(370));

        assertEquals(1, p.getAge(), "The age is ok");
    }

    @Test
    @DisplayName("Student Test")
    public void shouldGetAStudentAge() {

        Student s = new Student("Juan", LocalDate.now().minusDays(740), 4.9);

        assertEquals(2, s.getAge(), "The age is ok");
        assertTrue(s.isApproved(), "Student has approved");
    }

    @Test
    @DisplayName("Display class name")
    public void shouldDisplayClassName() {

        Person p = new Person("Juan", LocalDate.now().minusDays(370));
        Student s = new Student("Juan", LocalDate.now().minusDays(740), 4.9);

        assertEquals("Person", p.getClass().getName());
        assertEquals("Student", s.getClass().getName());

        Person p1 = s;
        assertEquals("Student", p1.getClass().getName());
        assertEquals("Student", ((Person) s).getClass().getName());
    }

    @Test
    @DisplayName("Instance Of")
    public void shouldValidateInstanceOf() {

        Person p = new Person("Juan", LocalDate.now().minusDays(370));
        Student s = new Student("Juan", LocalDate.now().minusDays(740), 4.9);

        assertTrue(p instanceof Person);
        assertTrue(s instanceof Student);

        assertTrue(s instanceof Person);

    }
}
