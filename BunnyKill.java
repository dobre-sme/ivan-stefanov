package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BunnyKill {

    public static boolean isInBound(int x, int y, int[][] matrix) {
        if (x >= 0 && x <= matrix.length && y >= 0 && y <= matrix.length) {
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] matrix = new int[3][3];

        for (int i = 0; i < matrix.length; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = input[j];
            }
        }

        String[] bombs = scanner.nextLine().split(" ");
        for (int i = 0; i < bombs.length; i++) {
            int[] bombCoordinates = Arrays.stream(bombs[i].split(",")).mapToInt(Integer::parseInt).toArray();
            int X = bombCoordinates[0];
            int Y = bombCoordinates[1];
            int bomb = matrix[X][Y];

            // check up
            if (isInBound(X - 1, Y, matrix)) {
                int numUp = matrix[X - 1][Y];
                if (bomb >= numUp) {
                    matrix[X - 1][Y] = 0;
                } else {
                    matrix[X - 1][Y] = numUp - bomb;
                }
            }

            //check down
            if (isInBound(X + 1, Y, matrix)) {
                int numDown = matrix[X + 1][Y];
                if (bomb >= numDown) {
                    matrix[X + 1][Y] = 0;
                } else {
                    matrix[X + 1][Y] = numDown - bomb;
                }

            }
            //check left
            if (isInBound(X, Y-1, matrix)) {
                int numLeft = matrix[X][Y-1];
                if (bomb >= numLeft) {
                    matrix[X][Y-1] = 0;
                } else {
                    matrix[X][Y-1] = numLeft - bomb;
                }

            }
            //check right
            if (isInBound(X, Y+1, matrix)) {
                int numRight = matrix[X][Y+1];
                if (bomb >= numRight) {
                    matrix[X][Y+1] = 0;
                } else {
                    matrix[X][Y+1] = numRight - bomb;
                }

            }
            //check UpLeftDiagonal
            if (isInBound(X+1, Y-1, matrix)) {
                int numUpLeft = matrix[X+1][Y-1];
                if (bomb >= numUpLeft) {
                    matrix[X+1][Y-1] = 0;
                } else {
                    matrix[X+1][Y-1] = numUpLeft - bomb;
                }

            }
            //check UpRightDiagonal
            if (isInBound(X-1, Y+1, matrix)) {
                int numUpRight = matrix[X-1][Y+1];
                if (bomb >= numUpRight) {
                    matrix[X-1][Y+1] = 0;
                } else {
                    matrix[X-1][Y+1] = numUpRight - bomb;
                }

            }
            //check DownLeftDiagonal
            if (isInBound(X-1, Y-1, matrix)) {
                int numDownLeft = matrix[X-1][Y-1];
                if (bomb >= numDownLeft) {
                    matrix[X-1][Y-1] = 0;
                } else {
                    matrix[X-1][Y-1] = numDownLeft - bomb;
                }

            }
            //check DownRightDiagonal
            if (isInBound(X+1, Y+1, matrix)) {
                int numDownRight = matrix[X+1][Y+1];
                if (bomb >= numDownRight) {
                    matrix[X+1][Y+1] = 0;
                } else {
                    matrix[X+1][Y+1] = numDownRight - bomb;
                }

            }
        }


        int damageDone = 0;
        int attacksCount = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                if (matrix[rows][cols] > 0){
                    damageDone += matrix[rows][cols];
                    attacksCount++;
                }
            }
        }

        System.out.println(damageDone);
        System.out.println(attacksCount);

    }
}
