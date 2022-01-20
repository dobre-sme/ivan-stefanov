package Jan19;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetArmada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "(?<activity>[0-9]+) = (?<legionName>[^=>: -]+) -> (?<soldierType>[^=>: -]+):(?<soldierCount>\\d+)";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;

        String legionName;
        String soldierType;
        int soldierCount;
        int legionActivity;

        Map<String, Map<String, Integer>> legionAndSoldiersMap = new LinkedHashMap<>();
        Map<String, Integer> legionAndActivityMap = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            matcher = pattern.matcher(scanner.nextLine());
            if (matcher.find()) {
                legionName = matcher.group("legionName");
                soldierType = matcher.group("soldierType");
                soldierCount = Integer.parseInt(matcher.group("soldierCount"));
                legionActivity = Integer.parseInt(matcher.group("activity"));

                //add legion name if it doesnt exist
                if (!legionAndSoldiersMap.containsKey(legionName)) {
                    legionAndSoldiersMap.put(legionName, new LinkedHashMap<>());
                }
                //add soldier to legion , if it doesnt exist
                if (!legionAndSoldiersMap.get(legionName).containsKey(soldierType)) {
                    legionAndSoldiersMap.get(legionName).put(soldierType, soldierCount);
                } else {
                    //add soldiers count if it already exist in the legion
                    int currentSoldiersCount = legionAndSoldiersMap.get(legionName).get(soldierType); //lastEdit
                    legionAndSoldiersMap.get(legionName).put(soldierType, soldierCount + currentSoldiersCount);
                }

                //update legion activity if higher
                legionAndActivityMap.putIfAbsent(legionName, legionActivity);
                if (legionActivity > legionAndActivityMap.get(legionName)) {
                    legionAndActivityMap.put(legionName, legionActivity);
                }
            }

        }

        String inputRegex = "(?<activity>[0-9]+)\\\\(?<soldierType>[^=>: -]+)";

        String input = scanner.nextLine();

        pattern = Pattern.compile(inputRegex);
        matcher = pattern.matcher(input);

        Map<String, Integer> firstCasePrintMap = new LinkedHashMap<>();
        Map<String, Integer> secondCasePrintMap = new LinkedHashMap<>();

        if (matcher.find()) {
            int givenActivity = Integer.parseInt(matcher.group("activity"));
            String givenSoldierType = matcher.group("soldierType");

            for (Map.Entry<String, Integer> stringIntegerEntry : legionAndActivityMap.entrySet()) {
                if (stringIntegerEntry.getValue() < givenActivity) {
                    if (legionAndSoldiersMap.get(stringIntegerEntry.getKey()).containsKey(givenSoldierType)) {
                        firstCasePrintMap.put(stringIntegerEntry.getKey(), legionAndSoldiersMap.get(stringIntegerEntry.getKey()).get(givenSoldierType));

                    }
                }
            }

            firstCasePrintMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> System.out.println(x.getKey() + " -> " + x.getValue()));

        } else {
            soldierType = input;

            for (Map.Entry<String, Map<String, Integer>> stringMapEntry : legionAndSoldiersMap.entrySet()) {
                if (legionAndSoldiersMap.get(stringMapEntry.getKey()).containsKey(soldierType)) {
                    secondCasePrintMap.put(stringMapEntry.getKey(), legionAndActivityMap.get(stringMapEntry.getKey()));
                }
            }

            secondCasePrintMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> System.out.println(x.getValue() + " : " + x.getKey()));
        }

    }
}
