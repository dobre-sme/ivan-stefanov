package Jan21;

import java.util.*;

public class LINQuistics07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, HashSet<String>> linquistics = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while(!command.equals("exit")){
            String[] input = command.split("\\."); // = ["collection", "method()", "method()", "method()"]
            String collection = input[0];

            if (linquistics.containsKey(input[0]) && input.length == 1){ // given collection name -> print the methods it has
                linquistics.get(input[0]).stream().sorted((e1,e2) -> {
                    if (e2.length() == e1.length()){
                        return Integer.compare(getUniqueSymbols(e2), getUniqueSymbols(e1));
                    }else if (e2.length() > e1.length()){
                        return 1;
                    }else {
                        return -1;
                    }
                }).forEach(e -> System.out.printf("* %s%n", e));


            }else if (Character.isDigit(input[0].charAt(0))){
                int n = Integer.parseInt(input[0]);
                String collectionToIterate = getCollectionWithMostMethods(linquistics);

                linquistics.get(collectionToIterate).stream().sorted(Comparator.comparing(LINQuistics07::getLength)).limit(n).forEach(e -> System.out.printf("*  %s%n", e));
            }

            for (int i = 1; i < input.length; i++) { //adds method to collection without '()'
                String method = input[i].replaceAll("\\(\\)", "");
                linquistics.putIfAbsent(collection, new LinkedHashSet<>());
                linquistics.get(collection).add(method);
            }

            command = scanner.nextLine();
        }

        String[] inputLine = scanner.nextLine().split(" ");
        String givenMethod = inputLine[0];
        String givenSelection = inputLine[1]; //either 'collection' or 'all';


        if (givenSelection.equals("collection")){

          linquistics.entrySet().stream().sorted((e1,e2) -> {
                if (e2.getValue().size() == e1.getValue().size()){
                    if (getShortestWord(e2.getValue()).length() > getShortestWord(e1.getValue()).length()){
                        return 1;
                    }else if (getShortestWord(e2.getValue()).length() < getShortestWord(e1.getValue()).length()){
                        return -1;
                    }
                }else if(e2.getValue().size() > e1.getValue().size()){
                    return 1;
                }else {
                    return -1;
                }
                return 0;
            }).filter(stringHashSetEntry -> stringHashSetEntry.getValue().contains(givenMethod)).forEach(e -> System.out.println(e.getKey()));

        }else if (givenSelection.equals("all")){
            linquistics.entrySet().stream().sorted((e1,e2) -> {
                if (e2.getValue().size() == e1.getValue().size()){
                    if (getShortestWord(e2.getValue()).length() > getShortestWord(e1.getValue()).length()){
                        return 1;
                    }else if (getShortestWord(e2.getValue()).length() < getShortestWord(e1.getValue()).length()){
                        return -1;
                    }
                }else if(e2.getValue().size() > e1.getValue().size()){
                    return 1;
                }else {
                    return -1;
                }
                return 0;
            }).filter(stringHashSetEntry -> stringHashSetEntry.getValue().contains(givenMethod)).forEach(e -> {
                System.out.println(e.getKey());
                e.getValue().stream().sorted((e1,e2) -> {
                    if (e1.length() > e2.length()){
                        return -1;
                    }else if (e1.length() < e2.length()){
                        return 1;
                    }
                    return 0;
                }).forEach(s -> {
                    System.out.printf("* %s%n", s);
                });

            });
        }

    }

    private static String getShortestWord(HashSet<String> hashset) {
        String shortestWord = "ThatsOneVeryVeryVeryVeryVeryLongWord";
        for (String s : hashset) {
            if (s.length() < shortestWord.length()){
                shortestWord = s;
            }
        }
        return shortestWord;
    }

    public static int getUniqueSymbols(String method){
        Set<Character> counter = new HashSet<>();
        for (int i = 0; i < method.length(); i++) {
            counter.add(method.charAt(i));
        }
        return counter.size();
    }

    public static int getLength(String word){
        return word.length();
    }

    public static String getCollectionWithMostMethods(Map<String,HashSet<String>> map){
        String collectionName = "";
        int count = 0;

        for (Map.Entry<String, HashSet<String>> stringHashSetEntry : map.entrySet()) {
            if (stringHashSetEntry.getValue().size() > count){
                count = stringHashSetEntry.getValue().size();
                collectionName = stringHashSetEntry.getKey();
            }
        }

        return collectionName;
    }

}
