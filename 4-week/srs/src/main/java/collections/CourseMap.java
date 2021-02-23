package collections;

import entities.Course;
import entities.Student;

import java.util.*;

public class CourseMap implements CourseCollectionsExample {

    public static final int MAXIMUM_QUOTA = 30;
    private Map<Integer, Student> students;

    public CourseMap() {
        this.students = new HashMap<>();
    }

    @Override
    public int numMaxStudents() {
        return MAXIMUM_QUOTA;
    }

    @Override
    public int numRegisteredStudents() {
        return students.size();
    }

    @Override
    public boolean addStudent(Student s) {
        boolean result = false;

        if (numRegisteredStudents() < MAXIMUM_QUOTA) {
            if (!students.containsKey(s.getId())) {
                students.put(s.getId(), s);
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean removeStudent(Student s) {

        return students.remove(s.getId()) != null;
    }

    @Override
    public Student getStudent(Student s) {
        return students.get(s.getId());

    }

    @Override
    public Student updateStudent(Student s) {
        Student result = null;
        if (students.containsKey(s.getId())) {
            result = students.replace(s.getId(), s);
        }
        return result;
    }
}
