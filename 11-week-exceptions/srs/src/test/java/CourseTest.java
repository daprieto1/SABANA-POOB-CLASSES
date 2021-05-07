import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    @DisplayName("GIVEN a course WHEN register a student THEN should allow")
    void shouldAllowRegisterAStudent() {

        Student student = new Student(1, "Juan");
        Course course = new Course(1, "Programación Orientada a Objetos");

        try {
            course.register(student);
        } catch (UniversityCourseException e) {
            fail();
        }
    }

    @Test
    @DisplayName("GIVEN a course with quota WHEN register a student that is currently registered THEN should not allow")
    void shouldNotAllowRegisterARegisteredStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(1, "Pedro");
        Course course = new Course(1, "Programación Orientada a Objetos");

        try {
            course.register(student1);
        } catch (UniversityCourseException e) {
            fail();
        }

        UniversityCourseException e = assertThrows(UniversityCourseException.class, () -> course.register(student2));
        assertEquals(UniversityCourseException.STUDENT_EXISTS, e.getMessage());
    }

    @Test
    @DisplayName("GIVEN a course without quota WHEN register a student THEN should not allow")
    void shouldNotAllowRegisterAStudent() {

        Course course = new Course(1, "Programación Orientada a Objetos");
        Student student = new Student(Course.MAXIMUM_QUOTA + 1, "Juan");
        try {
            for (int i = 0; i < Course.MAXIMUM_QUOTA; i++) {
                int id = i + 1;
                course.register(new Student(id, "Juan " + id));
            }

        } catch (UniversityCourseException e) {
            fail(e.getMessage());
        }

        UniversityCourseException e = assertThrows(UniversityCourseException.class, () -> course.register(student));
        assertEquals(UniversityCourseException.COURSE_LIMIT, e.getMessage());
    }

}










