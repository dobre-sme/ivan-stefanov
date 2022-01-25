package Jan25;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountWorkingDays01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] startDateInput = scanner.nextLine().split("-");
        String[] endDateInput = scanner.nextLine().split("-");

        LocalDateTime startDate = LocalDateTime.of(Integer.parseInt(startDateInput[2]), Integer.parseInt(startDateInput[1]), Integer.parseInt(startDateInput[0]), 0, 0);
        LocalDateTime endDate = LocalDateTime.of(Integer.parseInt(endDateInput[2]), Integer.parseInt(endDateInput[1]), Integer.parseInt(endDateInput[0]), 0, 0);

        List<LocalDateTime> holidays = new ArrayList<>(8);
        holidays.add(LocalDateTime.of(startDate.getYear(), 1, 1, 0, 0));
        holidays.add(LocalDateTime.of(startDate.getYear(), 3, 3, 0, 0));
        holidays.add(LocalDateTime.of(startDate.getYear(), 5, 1, 0, 0));
        holidays.add(LocalDateTime.of(startDate.getYear(), 5, 6, 0, 0));
        holidays.add(LocalDateTime.of(startDate.getYear(), 5, 24, 0, 0));
        holidays.add(LocalDateTime.of(startDate.getYear(), 9, 6, 0, 0));
        holidays.add(LocalDateTime.of(startDate.getYear(), 9, 22, 0, 0));
        holidays.add(LocalDateTime.of(startDate.getYear(), 12, 24, 0, 0));
        holidays.add(LocalDateTime.of(startDate.getYear(), 12, 25, 0, 0));
        holidays.add(LocalDateTime.of(startDate.getYear(), 12, 26, 0, 0));


        int workingDays = 0;
            for (int day = startDate.getDayOfMonth(); day <= endDate.getDayOfMonth(); day++) {
                if (!holidays.contains(LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), 0, 0)) && !startDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !startDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                    workingDays++;
                }
                startDate = startDate.plusDays(1);
            }

        System.out.println(workingDays);


    }
}
