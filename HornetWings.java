package Jan19;

import java.util.Scanner;

public class HornetWings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int flapsCount = Integer.parseInt(scanner.nextLine());  // 2000
        double distancePer1000 = Double.parseDouble(scanner.nextLine()); //meters /5metra per 1000claps
        int flapsBeforeBreak = Integer.parseInt(scanner.nextLine());  // 5s break / 200flaps

        // 100 claps per sec
        double distance = ((flapsCount / 1000) * distancePer1000); //10m
        int flapTime = flapsCount / 100; // 20s
        double restTime = (flapsCount / flapsBeforeBreak) * 5; //50s

        System.out.println(distance + "m.");
        System.out.println(flapTime + restTime + "s.");
    }
}
