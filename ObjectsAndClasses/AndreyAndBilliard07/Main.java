package Jan25.AndreyAndBilliard07;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> menu = new HashMap<>();

        // add products to map

        for (int i = 0; i < n; i++) {
            String[] productInfo = scanner.nextLine().split("-");
            String product = productInfo[0];
            double price = Double.parseDouble(productInfo[1]);
            menu.put(product,price);

        }

        String input = scanner.nextLine();

        List<Customer> customers = new ArrayList<>();



        while (!input.equals("end of clients")){
            String[] buyList = input.split("-");
            String buyerName = buyList[0];
            String[] productAndCount = buyList[1].split(",");
            String productName = productAndCount[0];
            int productCount = Integer.parseInt(productAndCount[1]);

            Map<String,Integer> newList = new HashMap<>();
            if (menu.containsKey(productName)){
                newList.put(productName,productCount);
                Customer customer = new Customer(buyerName, newList, 0.0);

                customers.add(customer);
            }


            input = scanner.nextLine();
        }

        // calculate bills
        for (Customer customer : customers) {
            customer.getBuyList().entrySet().forEach(e -> {
                double bill = 0;
                if(menu.containsKey(e.getKey())){
                    bill += menu.get(e.getKey()) * e.getValue();
                    customer.setBill(bill);
                }
            });
           // customer.setBill(customer.getBuyList());
        }

        customers.stream().sorted((e1,e2) -> e1.getName().compareTo(e2.getName())).forEach(e -> {
            System.out.println(e.getName());
            for (Map.Entry<String, Integer> stringIntegerEntry : e.getBuyList().entrySet()) {
                System.out.printf("-- %s - %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            }
            System.out.printf("Bill: %.2f%n", e.getBill());

        });
        //get total price
            double total = 0;
        for (Customer customer : customers) {
            total += customer.getBill();
        }

        System.out.printf("Total bill: %.2f", total);

    }
}
