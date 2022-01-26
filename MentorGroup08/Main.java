package Jan25.MentorGroup08;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Student> studentMap = new LinkedHashMap<>();

        DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        while(!input.equals("end of dates")){
            String[] data = input.split(" ");
            String username = data[0];
            String[] dateList = data[1].split(",");
            List<LocalDate> currentDates = new ArrayList<>();

            if (dateList.length > 1){
                for (int i = 0; i < dateList.length; i++) {
                    currentDates.add(LocalDate.parse(dateList[i], df));
                }
            }else {
                currentDates.add(LocalDate.parse(dateList[0], df));
            }

            if (!studentMap.containsKey(username)){
                studentMap.put(username, new Student(username, new ArrayList<>(), currentDates));
            }else {
                for (int i = 0; i < currentDates.size(); i++) {
                    studentMap.get(username).datesAttended.add(currentDates.get(i));
                }
            }
            input = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while(!command.equals("end of comments")){
            String[] commandData = command.split("-");
            String userToComment = commandData[0];
            String comment = commandData[1];

            if (studentMap.containsKey(userToComment)){
                studentMap.get(userToComment).comments.add(comment);
            }

            command = scanner.nextLine();
        }

        studentMap.keySet().stream().sorted().forEach(e -> { // removed sorted
            System.out.println(e);
            System.out.println("Comments:");
            for (String comment : studentMap.get(e).comments) {
                System.out.printf("- %s%n", comment);
            }
            System.out.println("Dates attended:");
            studentMap.get(e).datesAttended.stream().sorted((e2,e1) -> e2.compareTo(e1)).forEach(ef -> {
                System.out.printf("-- %s%n", ef);
            });
        });


        System.out.println();






    }
}
