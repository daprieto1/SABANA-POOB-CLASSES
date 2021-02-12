import java.util.Objects;

public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Student or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Student)) {
            return false;
        }

        // typecast o to Student so that we can compare data members
        Student s = (Student) o;

        // Compare the data members and return accordingly
        return this.id == s.getId();
    }
}
