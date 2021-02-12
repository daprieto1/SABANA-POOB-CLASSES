import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a Course. <br><br>
 * Invariants:
 * 1. MAXIMUM_QUOTA > 0
 * 2. MAXIMUM_QUOTA >= number of registered students. <br><br>
 * @author diego.prieto
 */
public class Course {

    public static final int MAXIMUM_QUOTA = 30;

    private int id;
    private String name;
    private List<Student> students;
    private Set<Student> studentSet;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
        this.students = new ArrayList<>();
        this.studentSet = new HashSet<>();
    }

    /**
     * If is possible register a new student into the course. The conditions are: <br><br>
     * 1. There is quota into the course. <br>
     * 2. The student has not been registered into the course. <br>
     * 3. The student has the pre requirements. <br>
     * <br>
     * @param student The student to be added.
     * @return true if the student was successfully regustered, otherwise false.
     */
    public boolean registerList(Student student) {
        boolean exists = false;
        boolean result = false;

        if (MAXIMUM_QUOTA > this.students.size()) {
            for (int i = 0; i < this.students.size() && !exists; i++) {
                if (this.students.get(i).equals(student)) {
                    exists = true;
                }
            }

            if (!exists) {
                result = this.students.add(student);
            }
        }

        return result;
    }

    public boolean register(Student student) {

        if (MAXIMUM_QUOTA > this.studentSet.size()) {
            return this.studentSet.add(student);
        }

        return false;
    }
}