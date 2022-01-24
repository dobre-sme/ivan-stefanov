package Jan21;

import java.util.*;

public class MostValuedCustomer04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Double> inventory = new HashMap<>();

        while (!input.equals("Shop is open")) {
            String[] product = input.split(" ");
            String productName = product[0];
            double productPrice = Double.parseDouble(product[1]);

            inventory.put(productName, productPrice);

            input = scanner.nextLine();
        }

        Map<String, Map<String, Integer>> peopleCarts = new HashMap<>();
        List<String> customers = new ArrayList<>();

        String command = scanner.nextLine();
        int discountCount = 0;
        while (!command.equals("Print")) {
            if (command.equals("Discount")) {
                discountCount++;
            } else {
                String[] commandData = command.split(": ");
                String nameOfCustomer = commandData[0];
                peopleCarts.putIfAbsent(nameOfCustomer, new TreeMap<>());
                String[] shoppingList = commandData[1].split(", ");
                for (int i = 0; i < shoppingList.length; i++) {
                    if (inventory.containsKey(shoppingList[i])) {
                        if (!customers.contains(nameOfCustomer)) {
                            customers.add(nameOfCustomer);
                        }
                        if (!peopleCarts.get(nameOfCustomer).containsKey(shoppingList[i])) {
                            peopleCarts.get(nameOfCustomer).put(shoppingList[i], 1);
                        } else {
                            int currentCount = peopleCarts.get(nameOfCustomer).get(shoppingList[i]);
                            currentCount++;
                            peopleCarts.get(nameOfCustomer).put(shoppingList[i], currentCount);
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }

        //add discount
        for (int i = 0; i < discountCount; i++) {
            inventory.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(3).forEach(e -> {
                e.setValue(e.getValue() * 0.9);
            });
        }

        double biggestSpenderAmount = Integer.MIN_VALUE;
        String biggestSpender = "";
        Map<String, Integer> biggestSpenderList = null;
        for (int i = 0; i < peopleCarts.size(); i++) {
            double totalSpent = 0;
            totalSpent += peopleCarts.get(customers.get(i)).entrySet().stream().mapToDouble(e -> inventory.get(e.getKey()) * e.getValue()).sum();
            if (totalSpent > biggestSpenderAmount) {
                biggestSpenderAmount = totalSpent;
                biggestSpender = customers.get(i);
                biggestSpenderList = new HashMap<String, Integer>(peopleCarts.get(customers.get(i)));
            }

        }

        System.out.println("Biggest spender: " + biggestSpender);
        System.out.println("^Products bought: ");
        for (Map.Entry<String, Integer> stringIntegerEntry : biggestSpenderList.entrySet()) {
            System.out.printf("^^^%s: %.2f%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue() * inventory.get(stringIntegerEntry.getKey()));
        }
        System.out.printf("Total: %.2f", biggestSpenderAmount);
    }


}
