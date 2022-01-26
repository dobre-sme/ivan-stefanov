package Jan25.MentorGroup08;

import java.time.LocalDate;
import java.util.List;

public class Student {

    String name;
    List<String> comments;
    List<LocalDate> datesAttended;

    public Student(String name, List<String> comments, List<LocalDate> datesAttended) {
        this.name = name;
        this.comments = comments;
        this.datesAttended = datesAttended;
    }
}
