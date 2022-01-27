package Jan25.StudentGroups10;

import java.util.List;

public class Group {
    private Town town;
    private List<Student> students;

    public Group(Town town, List<Student> students) {
        this.town = town;
        this.students = students;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
