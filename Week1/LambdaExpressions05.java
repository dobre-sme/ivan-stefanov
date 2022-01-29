package Jan21;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LambdaExpressions05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, String>> lambadas = new LinkedHashMap<>();

        while (!input.equals("lambada")) {

            if (input.equals("dance")) {

                for (Map.Entry<String, Map<String, String>> stringMapEntry : lambadas.entrySet()) {
                    String selectorObject = stringMapEntry.getValue().keySet().iterator().next() + "." + stringMapEntry.getKey();
                    String property = stringMapEntry.getValue().get(stringMapEntry.getValue().keySet().iterator().next());

                    lambadas.put(stringMapEntry.getKey(), Map.of(selectorObject,property));
                }

            } else {
                String[] data = input.split(" => ");
                String selector = data[0];
                String selectorObject = data[1].split("\\.")[0];
                String property = data[1].split("\\.")[1];
                lambadas.putIfAbsent(selector, new LinkedHashMap<>());
                lambadas.get(selector).put(selectorObject,property);
            }


            input = scanner.nextLine();
        }


        lambadas.entrySet().forEach(e -> System.out.println(e.getKey() + " => " + lambadas.get(e.getKey()).keySet().iterator().next() + "." + lambadas.get(e.getKey()).values().iterator().next()));

        System.out.println();
    }
}
