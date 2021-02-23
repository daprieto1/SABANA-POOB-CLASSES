package collections;

import entities.Course;
import entities.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CourseSet implements CourseCollectionsExample {

    public static final int MAXIMUM_QUOTA = 30;
    private Set<Student> students;

    public CourseSet() {
        this.students = new HashSet<>();
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
            result = students.add(s);
        }

        return result;
    }

    @Override
    public boolean removeStudent(Student s) {
        return students.remove(s);
    }

    @Override
    public Student getStudent(Student s) {
        Student result = null;
        Iterator<Student> it = students.iterator();

        while (result == null && it.hasNext()) {
            Student student = it.next();
            if (student.equals(s)) {
                result = student;
            }
        }

        return result;

    }

    @Override
    public Student updateStudent(Student s) {
        if (!students.remove(s)) {
            return null;
        }
        students.add(s);
        return s;
    }
}
