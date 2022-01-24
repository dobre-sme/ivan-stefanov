package Jan21;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderedBankingSystem06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> banks = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] data = input.split(" -> ");
            String bank = data[0];
            String account = data[1];
            double balance = Double.parseDouble(data[2]);

            banks.putIfAbsent(bank,new LinkedHashMap<>());

            if(!banks.get(bank).containsKey(account)){
                banks.get(bank).put(account,balance);
            }else {
                double currentValue = banks.get(bank).get(account);
                banks.get(bank).put(account, currentValue + balance);
            }

            input = scanner.nextLine();
        }
        banks.entrySet().stream().sorted((e1,e2) -> {
            double e2bankSum = e2.getValue().values().stream().mapToDouble(d -> d).sum();
            double e1bankSum = e1.getValue().values().stream().mapToDouble(d -> d).sum();
            int result = (int) (e2bankSum - e1bankSum);
            if (result == 0){
                double maxBalanceE1 = getHighestBalance(e1.getValue());
                double maxBalanceE2 = getHighestBalance(e2.getValue());
                result = (int) (maxBalanceE2 - (int) maxBalanceE1);
            }
            return result;
        }).forEach(e -> {
                System.out.println(e.getValue().keySet().iterator().next() + " -> " + e.getValue().values().iterator().next() + "(" +e.getKey() + ")");
        });
    }

    public static double getHighestBalance(Map<String,Double> banks){
        double maxBalance = Double.MIN_VALUE;
        for (Double value : banks.values()) {
            if (value > maxBalance){
                maxBalance = value;
            }
        }
        return maxBalance;
    }
}
