package Jan25.AverageGrades04;

import java.util.OptionalDouble;

public class Student {
    //Define a class Student, which holds the following information about students: name, list of grades and average grade (calculated property, read-only). A single grade will be in range [2…6], e.g. 3.25 or 5.50.
    //Read a list of students and print the students that have average grade ≥ 5.00 ordered by name (ascending), then by average grade (descending). Print the student name and the calculated average grade.

    String name;
    double[] grades;
    OptionalDouble averageGrade;

    //Arrays.stream(new int[] {1,2,3,4}) //Converts int[] to IntStream
    //.map(n -> n * n) //Squares each element of the stream, now we have 1, 4, 9, 16
    //.average() // Calculate average between those numbers, it's 7.5
    //.ifPresent(System.out::println); //We have an Optional<Double>, if it's present we print it.

    public Student(String name, double[] grades, OptionalDouble averageGrade) {
        this.name = name;
        this.grades = grades;
        this.averageGrade = averageGrade;
    }
}
