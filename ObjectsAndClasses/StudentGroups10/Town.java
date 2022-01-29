package Jan25.StudentGroups10;

import java.util.List;

public class Town {
    private String name;
    private int seatsCount;
    private List<Student> students;

    public Town(String name, int seatsCount, List<Student> studList) {
        this.name = name;
        this.seatsCount = seatsCount;
        this.students = studList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
