package PawInc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    private static Map<String, List<Animal>> centers = new HashMap<>();

    private static List<String> adoptedAnimalsList = new ArrayList<>();

    public static List<String> getAdoptedAnimalsList() {
        return adoptedAnimalsList;
    }

    public static Map<String, List<Animal>> getAdoptionCenters() {
        return centers;
    }

    public static void registerAdoptionCenter(String name) {
        centers.put(name, new ArrayList<>());
    }

    public static void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        centers.get(adoptionCenterName).add(new Dog(name, age, learnedCommands, adoptionCenterName));

    }

    public static void registerCat(String name, int age, int IQ, String adoptionCenterName) {
        centers.get(adoptionCenterName).add(new Cat(name, age, IQ, adoptionCenterName));
    }

    public static void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        for (Animal animal : centers.get(adoptionCenterName)) {
            if (!animal.getCleanStatus()) {
                CleansingCenter.getCenters().get(cleansingCenterName).add(animal);

            }
        }
        for (Animal animal : CleansingCenter.getCenters().get(cleansingCenterName)) {
            centers.get(adoptionCenterName).removeIf(animal1 -> animal.getName().equals(animal1.getName()));
        }
    }

    public static void adopt(String adoptCenterName) {
        for (Animal animal : centers.get(adoptCenterName)) {
            if (animal.getCleanStatus()) {
                adoptedAnimalsList.add(animal.getName());
            }
        }

        for (String s : adoptedAnimalsList) {
            centers.get(adoptCenterName).removeIf(animal -> s.equals(animal.getName()));
        }
    }

    public static int animalsAwaitingAdoption(){
        int count = 0;
        for (List<Animal> value : centers.values()) {
            for (Animal animal : value) {
                if (animal.getCleanStatus()){
                    count++;
                }
            }
        }
        return count;
    }
}
