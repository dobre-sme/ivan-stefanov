package Jan25.StudentGroups10;

import java.time.LocalDate;

public class Student {
    private String name;
    private String email;
    private LocalDate registrationDate;

    public Student(String name, String email, LocalDate registrationDate) {
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
