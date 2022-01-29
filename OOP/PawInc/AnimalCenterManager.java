package PawInc;

import java.util.*;

public class AnimalCenterManager {

   // private static Map<String, Center> adoptionCenterMap = new HashMap<>();
    //private static Map<String, Center> cleansingCenterMap = new HashMap<>();
   // private static List<String> adoptedAnimals = new ArrayList<>();
   // private static List<String> cleansedAnimals = new ArrayList<>();

    //private static Map<String,Center> centers = new HashMap<>();

    static void registerCleansingCenter(String name) {
        CleansingCenter.registerCleansingCenter(name);
    } //done
    public static void registerAdoptionCenter(String name) {
        AdoptionCenter.registerAdoptionCenter(name);
    } //done

    static void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        AdoptionCenter.registerDog(name, age, learnedCommands, adoptionCenterName);
    } //done

    static void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        AdoptionCenter.registerCat(name,age,intelligenceCoefficient,adoptionCenterName);
    } //done

    static void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        AdoptionCenter.sendForCleansing(adoptionCenterName, cleansingCenterName);
    }
    static void cleanse(String cleansingCenterName) {
        CleansingCenter.cleanse(cleansingCenterName);
    }

    static void adopt(String adoptionCenterName) {
        AdoptionCenter.adopt(adoptionCenterName);

    }

    static void printStatistics() {

        System.out.println("Paw Incorporative Regular Statistics");
        System.out.printf("Adoption Centers: %d%n", AdoptionCenter.getAdoptionCenters().size());
        System.out.printf("Cleansing Centers: %d%n", CleansingCenter.getCenters().size());
        System.out.print("Adopted Animals: ");
        Collections.sort(AdoptionCenter.getAdoptedAnimalsList());
        System.out.print(String.join(", ", AdoptionCenter.getAdoptedAnimalsList()));
        System.out.println();
        System.out.print("Cleansed Animals: ");
        Collections.sort(CleansingCenter.getCleansedAnimals());
        System.out.print(String.join(", ", CleansingCenter.getCleansedAnimals()));
        System.out.println();
        System.out.printf("Animals awaiting adoption: %d%n", AdoptionCenter.animalsAwaitingAdoption());
        System.out.printf("Animals awaiting cleaning: %d", CleansingCenter.animalsAwaitingCleaning());

    }


}
