public class UniversityCourseException extends Exception {

    public static final String COURSE_LIMIT = "The course has no more space to register another student.";
    public static final String STUDENT_EXISTS = "The student has been registered in the course.";

    public UniversityCourseException(String message) {
        super(message);
    }
}
