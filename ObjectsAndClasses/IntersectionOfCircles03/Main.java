package Jan25.IntersectionOfCircles03;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int X = input[0];
        int Y = input[1];
        int radius = input[2];

        int[] input2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int X2 = input[0];
        int Y2 = input[1];
        int radius2 = input[2];

        Circle circle1 = new Circle(new Point(X,Y), radius);

        Circle circle2 = new Circle(new Point(X2,Y2), radius2);

        if (intersect(circle1, circle2)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }


    }

    public static boolean intersect(Circle one, Circle two) {
        double distance = Point.distance(one.center.x, one.center.y, two.center.x, two.center.y);
        if (distance <= one.radius + two.radius){
            return true;
        }
        return false;
    }


}
