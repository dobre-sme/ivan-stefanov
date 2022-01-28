package PawInc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while(!command.equals("Paw Paw Pawah")){
            String[] data = command.split(" \\| ");
            switch (data[0]){
                case "RegisterCleansingCenter":
                    AnimalCenterManager.registerCleansingCenter(data[1]);
                    break;
                case "RegisterAdoptionCenter":
                    AnimalCenterManager.registerAdoptionCenter(data[1]);
                    break;
                case "RegisterDog":
                    AnimalCenterManager.registerDog(data[1],Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
                    break;
                case "RegisterCat":
                    AnimalCenterManager.registerCat(data[1],Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
                    break;
                case "SendForCleansing":
                    AnimalCenterManager.sendForCleansing(data[1],data[2]);
                    break;
                case "Cleanse":
                    AnimalCenterManager.cleanse(data[1]);
                    break;
                case "Adopt":
                    AnimalCenterManager.adopt(data[1]);
                    break;
            }

            command = scanner.nextLine();
        }

        AnimalCenterManager.printStatistics();

    }
}
