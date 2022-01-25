package Jan25.BookLibraryModification06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split(" ");
            String title = input[0];
            String author = input[1];
            String publisher = input[2];
            int dateDay = Integer.parseInt(input[3].split("\\.")[0]);
            int dateMonth = Integer.parseInt(input[3].split("\\.")[1]);
            int dateYear = Integer.parseInt(input[3].split("\\.")[2]);
            LocalDateTime releaseDate = LocalDateTime.of(dateYear, dateMonth, dateDay,0,0);//LocalDateTime.parse(input[3], DateTimeFormatter.ISO_LOCAL_DATE);
            int number = Integer.parseInt(input[4]);
            double price = Double.parseDouble(input[5]);

            Book book = new Book(title, author, publisher, releaseDate, number, price);
            bookList.add(book);
        }

        Library library = new Library("MyLibrary", bookList);

        String inputDate = scanner.nextLine();
        int dateDayF = Integer.parseInt(inputDate.split("\\.")[0]);
        int dateMonthF = Integer.parseInt(inputDate.split("\\.")[1]);
        int dateYearF = Integer.parseInt(inputDate.split("\\.")[2]);
        LocalDateTime filterDate = LocalDateTime.of(dateYearF, dateMonthF, dateDayF,0,0);

        DateTimeFormatter fmt = new DateTimeFormatterBuilder()
                .appendPattern("dd.MM.yyyy")
                .optionalStart()
                .optionalEnd()
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .toFormatter();

        bookList.stream().filter(e -> e.getReleaseDate().isAfter(filterDate)).sorted((e2,e1) -> {
            if (e2.getReleaseDate().compareTo(e1.getReleaseDate()) == 0){
                return e2.getTitle().compareTo(e1.getTitle());
            }
            return 0;
        }).forEach(e -> System.out.printf("%s -> %s%n", e.getTitle(), fmt.format(e.getReleaseDate())));

    }
}
