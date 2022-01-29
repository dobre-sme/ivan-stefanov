package Jan19;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HornetAssault {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> beehives = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> hornets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int hornetsPower = hornets.stream().mapToInt(Integer::intValue).sum();

        for (int i = 0; i < beehives.size(); i++) {
            if (hornetsPower <= beehives.get(i)){
                    beehives.set(i, beehives.get(i) - hornetsPower);
                    hornets.remove(0);
                    hornetsPower = hornets.stream().mapToInt(Integer::intValue).sum();
            }else if(hornetsPower >= beehives.get(i)){
                beehives.set(i, beehives.get(i) - hornetsPower);
                beehives.set(i, Math.max(beehives.get(i) - hornetsPower, 0));
                if (hornetsPower == beehives.get(i)){
                    hornets.remove(0);
                    hornetsPower = hornets.stream().mapToInt(Integer::intValue).sum();
                }
            }
        }

        int hornetSum = hornets.stream().mapToInt(Integer::intValue).sum();
        int beeSum = beehives.stream().mapToInt(Integer::intValue).sum();

        if (beeSum > 0){

            for (int i = 0; i < beehives.size(); i++) {
                if (beehives.get(i) > 0){
                    if (i == beehives.size() - 1)
                        System.out.print(beehives.get(i));
                    else
                        System.out.print(beehives.get(i) + " ");
                }
                }

        }else  {
            for (int i = 0; i < hornets.size(); i++) {
                if (hornets.get(i) > 0){
                    if (i == hornets.size() - 1)
                        System.out.print(hornets.get(i));
                    else
                        System.out.print(hornets.get(i) + " ");
                }
            }
        }

    }
}
