package Jan25.StudentGroups10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Town> townList = new ArrayList<>();
        List<Group> groupList = new ArrayList<>();
        Town town = null;
        Group group = null;
        Student student = null;

        String input = scanner.nextLine();

        while (!input.contains("End")) {

            readTownsAndStudents(input, townList);


            input = scanner.nextLine();
        }
        distributeStudentsIntoGroups(townList, groupList);


        System.out.printf("Created %d groups in %d towns:%n", groupList.size(), townList.size());
        groupList.stream().sorted((e1, e2) -> e1.getTown().getName().compareTo(e2.getTown().getName()))
                .forEach(e -> {
                    System.out.printf("%s => ", e.getTown().getName());
                    int c = 1;
                    for (Student eStudent : e.getStudents()) {
                        if (c < e.getStudents().size()) {
                            System.out.printf("%s, ", eStudent.getEmail());
                            c++;
                        } else {
                            System.out.printf("%s", eStudent.getEmail());
                        }

                    }
                    System.out.println();
                });

    }

    static void distributeStudentsIntoGroups(List<Town> townList, List<Group> groupList) {

        for (int i = 0; i < townList.size(); i++) {
            List<Student> sortedList = townList.get(i).getStudents().stream().sorted((e2, e1) -> {
                if (e2.getRegistrationDate().compareTo(e1.getRegistrationDate()) == 0) {
                    if (e2.getName().compareTo(e1.getName()) == 0) {
                        return e2.getEmail().compareTo(e1.getEmail());
                    } else {
                        return e2.getName().compareTo(e1.getName());
                    }
                } else {
                    return e2.getRegistrationDate().compareTo(e1.getRegistrationDate());
                }
            }).collect(Collectors.toList());

            while (!sortedList.isEmpty()) {
                List<Student> tempList = sortedList.stream().limit(townList.get(i).getSeatsCount()).collect(Collectors.toList());
                Group group = new Group(townList.get(i), tempList);
                groupList.add(group);
                if (sortedList.size() >= townList.get(i).getSeatsCount()) {
                    for (int j = 0; j < townList.get(i).getSeatsCount(); j++) {
                        sortedList.remove(0);
                    }
                } else {
                    sortedList = new ArrayList<>();
                }


            }

        }

    }

    private static void readTownsAndStudents(String input, List<Town> townList) {

        if (input.contains("=>")) {
            String townName = input.split(" => ")[0];
            int seats = Integer.parseInt(input.split(" => ")[1].split(" ")[0]);
            Town newTown = new Town(townName, seats, new ArrayList<>());
            townList.add(newTown);


        } else {
            DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern("d-MMM-yyyy").toFormatter();
            String[] studentData = input.replaceAll(" ", "").split("\\|");
            String name = input.split("\\|")[0].trim().replaceAll("\\s+", " ");
            String email = studentData[1];
            LocalDate date = LocalDate.parse(studentData[2], df);
            Student student = new Student(name, email, date);

            townList.get(townList.size() - 1).getStudents().add(student);

        }

    }
}
