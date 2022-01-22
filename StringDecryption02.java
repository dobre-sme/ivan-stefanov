package Jan21;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringDecryption02 implements Iterator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] command = scanner.nextLine().split(" ");
        int numsToRemove = Integer.parseInt(command[0]);
        int numsToPrint = Integer.parseInt(command[1]);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        for (int i = 0; i < nums.size(); i++) {

            if (nums.get(i) <65 || nums.get(i) > 90){
                nums.remove(i);
                i--;
            }

//  if (i+1 >= nums.size()){
//                break;
//            }
        }

        for (int i = 0; i < numsToRemove; i++) {
            nums.remove(0);
        }

        for (int i = 0; i < numsToPrint; i++) {
            int currentChar = nums.get(i);
            System.out.print((char) currentChar + " ");
        }




    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
