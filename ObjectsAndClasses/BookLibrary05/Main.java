package Jan25.BookLibrary05;

import java.time.LocalDateTime;
import java.util.*;

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

        Map<String,Double> authorTotal = new TreeMap<>();
        for (Book book : bookList) {
            authorTotal.putIfAbsent(book.getAuthor(), 0.0);
            authorTotal.put(book.getAuthor(), authorTotal.get(book.getAuthor()) + book.getPrice());
        }

        Library library = new Library("MyLibrary", bookList);

        authorTotal.entrySet().stream().sorted((e2,e1) -> {
            if (e1.getValue().compareTo(e2.getValue()) ==0){
                return e1.getKey().compareTo(e2.getKey());
            }else if (e1.getValue().compareTo(e2.getValue()) > 0){
                return 1;
            }else {
                return -1;
            }

        }).forEach(e ->
                System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));

    }
}
