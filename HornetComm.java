package Jan19;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetComm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String privateMessageRegex = "(?<firstQuery>\\d+) <-> (?<secondQuery>[0-9A-Z-a-z]+)$";
        String broadcastRegex = "^(?<firstQuery>[^0-9]+) <-> (?<secondQuery>[0-9A-Z-a-z]+)";

        Map<String, List<String>> map = new LinkedHashMap<>();
        map.put("Broadcasts", new ArrayList<>());
        map.put("Messages", new ArrayList<>());

        Pattern patternPrivate = Pattern.compile(privateMessageRegex);
        Pattern patternBroadcast = Pattern.compile(broadcastRegex);
        Matcher matcherPrivate = null;
        Matcher matcherBroadcast = null;
        StringBuilder sb = new StringBuilder();

        while(!input.equals("Hornet is Green")){
            matcherPrivate = patternPrivate.matcher(input);
            if (matcherPrivate.find()){
                sb.append(matcherPrivate.group("firstQuery")).reverse();
                map.get("Messages").add(sb + " -> " + matcherPrivate.group("secondQuery"));
                sb.setLength(0);
            }else {
                matcherBroadcast = patternBroadcast.matcher(input);
                    if (matcherBroadcast.find()){
                        String frequency = matcherBroadcast.group("secondQuery");
                        for (int i = 0; i < frequency.length(); i++) {
                            char currentChar = frequency.charAt(i);
                            if (Character.isLowerCase(currentChar)){
                                sb.append(Character.toUpperCase(currentChar));
                            }else {
                                sb.append(Character.toLowerCase(currentChar));
                            }
                        }

                        map.get("Broadcasts").add(sb + " -> " + matcherBroadcast.group("firstQuery"));
                        sb.setLength(0);
                    }
            }


            input = scanner.nextLine();
        }

        System.out.println("Broadcasts:");
        if (map.get("Broadcasts").isEmpty()){
            System.out.println("None");
        }else {
            map.get("Broadcasts").forEach(System.out::println);
        }

        System.out.println("Messages:");
        if (map.get("Messages").isEmpty()){
            System.out.println("None");
        }else {
            map.get("Messages").forEach(System.out::println);
        }

    }
}
