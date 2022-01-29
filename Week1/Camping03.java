package Jan21;

import java.util.*;

public class Camping03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, List<String>> ownerVehiclesMap = new TreeMap<>();
        Map<String, Integer> ownerTimeToStay = new HashMap<>();


        while(!command.equals("end")){
            String[] commandData = command.split(" ");
            String nameOfPerson = commandData[0];
            String camperModel = commandData[1];
            int timeToStay = Integer.parseInt(commandData[2]);

            if (!ownerVehiclesMap.containsKey(nameOfPerson)){
                ownerVehiclesMap.put(nameOfPerson, new ArrayList<>());
                ownerVehiclesMap.get(nameOfPerson).add(camperModel);
                ownerTimeToStay.put(nameOfPerson, timeToStay);
            }else {
                if (!ownerVehiclesMap.get(nameOfPerson).contains(camperModel)){
                    ownerVehiclesMap.get(nameOfPerson).add(camperModel);
                }
                int currentDays = ownerTimeToStay.get(nameOfPerson);
                ownerTimeToStay.put(nameOfPerson, currentDays + timeToStay);
            }


            command = scanner.nextLine();
        }

        ownerVehiclesMap.entrySet().stream().sorted((e1,e2) -> {
            if (e2.getValue().size() == e1.getValue().size()){
                return e2.getKey().length() - e1.getKey().length();
            }
            return e2.getValue().size() - e1.getValue().size();

        }).forEach(e -> {
            System.out.println(e.getKey() + ":" + " " + e.getValue().size());
            for (String s:e.getValue()) {
                System.out.println("***" + s);
            }
            System.out.println("Total stay: " + ownerTimeToStay.get(e.getKey()) + " nights");
        });
    }
}

