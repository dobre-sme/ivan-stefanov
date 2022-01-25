package Jan25.AverageGrades04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double[] grades;
        List<Student> listOfStudents = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            grades = new double[data.length - 1];
            for (int j = 1; j < data.length; j++) {
                grades[j - 1] = Double.parseDouble(data[j]);
            }

            OptionalDouble averageGrade = Arrays.stream(grades).average();
            Student student = new Student(name, grades, averageGrade);
            listOfStudents.add(student);
        }
        listOfStudents.stream().filter(student -> student.averageGrade.getAsDouble() >= 5).sorted((e2, e1) -> {
            if (e1.name.compareTo(e2.name) == 0) {
                return Double.compare(e1.averageGrade.getAsDouble(), e2.averageGrade.getAsDouble());
            }
            else return e2.name.compareTo(e1.name);

        }).forEach(s -> System.out.printf("%s -> %.2f%n", s.name, s.averageGrade.getAsDouble()));
    }
}
