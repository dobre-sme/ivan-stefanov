package com.company;

import java.util.Scanner;

public class MedenkaWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //The Dark Medenka Lord Naskor
        //The White Medenka Lord Vitkor

        //1 medenka - 60 damage

        double naskorMedenkas = 0;
        double vitkorMedenkas = 0;
        int naskorAttackCount = 0;
        int vitkorAttackCount = 0;
        double naskorLastMedenkas = 0;
        double vitkorLastMedenkas = 0;
        double currentAttackV = 0;
        double currentAttackN = 0;

        String command = scanner.nextLine();
        boolean isConsecutive = false;
        while(!command.equals("end")){
        String[] data = command.split("\\s+");
            int medenkaCount = Integer.parseInt(data[0]);
            switch (data[1]){
                case "white": // Vitkor attacks
                    if (vitkorAttackCount == 2 && vitkorLastMedenkas == medenkaCount){
                        vitkorMedenkas += medenkaCount * 2.75;
                        vitkorAttackCount = 0;
                        vitkorLastMedenkas = medenkaCount * 2.75;
                    }else {
                        vitkorMedenkas += medenkaCount;
                        vitkorLastMedenkas = medenkaCount;
                    }

                    if (medenkaCount == vitkorLastMedenkas || vitkorLastMedenkas == 0){
                        vitkorAttackCount++;
                    }else {
                        vitkorAttackCount = 0;
                    }


                    break;

                case "dark":  // Naskor attacks
                    if (naskorAttackCount == 4){
                        naskorMedenkas +=  medenkaCount * 4.5;
                        naskorLastMedenkas = medenkaCount * 4.5;
                        isConsecutive = true;
                    }else {
                        naskorMedenkas += medenkaCount;
                        naskorLastMedenkas = medenkaCount;
                    }

                    if (medenkaCount == naskorLastMedenkas || naskorLastMedenkas ==0){
                        naskorAttackCount++;
                    }else if (isConsecutive){
                        naskorAttackCount = 1;
                        isConsecutive = false;
                    }else {
                        naskorAttackCount = 0;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        if (vitkorMedenkas > naskorMedenkas){
            System.out.println("Winner - Vitkor");
            System.out.printf("%.0f", vitkorMedenkas * 60);
        }else {
            System.out.println("Naskor");
            System.out.printf("%.0f", naskorMedenkas * 60);
        }
    }
}
