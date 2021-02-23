package collections;

import entities.Student;

import java.util.ArrayList;
import java.util.Optional;

public class CourseArrayList implements CourseCollectionsExample {

    public static final int MAXIMUM_QUOTA = 30;

    private ArrayList<Student> students;

    public CourseArrayList() {
        students = new ArrayList<>();
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
        boolean exists = false;

        if (numRegisteredStudents() < MAXIMUM_QUOTA) {
            for (int i = 0; i < numRegisteredStudents() && !exists; i++) {
                if (students.get(i).equals(s)) {
                    exists = true;
                }
            }

            if (!exists) {
                students.add(s);
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean removeStudent(Student s) {

        return students.remove(s);
    }

    @Override
    public Student getStudent(Student s) {

        Optional<Student> result = students.stream().filter(st -> st.equals(s)).findFirst();
        return result.isPresent() ? result.get() : null;
    }

    @Override
    public Student updateStudent(Student s) {
        Student result = null;
        for (int i = 0; i < numRegisteredStudents() && result == null; i++) {
            if (students.get(i).equals(s)) {
                students.set(i, s);
                result = students.get(i);
            }
        }
        return result;
    }
}
