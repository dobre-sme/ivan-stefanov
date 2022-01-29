package Jan21;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayData01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        double averageNum = getAverage(nums);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < averageNum){
                nums.remove(i);
                i--;
            }
        }

        String command = scanner.nextLine();
        boolean printAll = false;
        int printNum = 0;

        switch (command) {
            case "Min":
                printNum = Integer.MAX_VALUE;
                for (int i = 0; i < nums.size(); i++) {
                    if (nums.get(i) < printNum){
                        printNum = nums.get(i);
                    }
                }
                break;
            case "Max":
                printNum = Integer.MIN_VALUE;
                for (int i = 0; i < nums.size(); i++) {
                    if (nums.get(i) > printNum){
                        printNum = nums.get(i);
                    }
                }
                break;
            case "All":
                Collections.sort(nums);
                printAll = true;
                break;
        }

        if (printAll){
            System.out.println(String.join(" ", nums.toString().replaceAll("[\\[\\],]", "")));
        }else {
            System.out.println(printNum);
        }


    }

    private static double getAverage(List<Integer> nums) {
        double result = 0;

        for (int i = 0; i < nums.size() ; i++) {
            result += nums.get(i);
        }


        return result / nums.size();
    }
}
