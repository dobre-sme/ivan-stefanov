package PawInc;

import java.util.*;

public class AnimalCenterManager {

    private static Map<String, Center> adoptionCenterMap = new HashMap<>();
    private static Map<String, Center> cleansingCenterMap = new HashMap<>();
    private static List<String> adoptedAnimals = new ArrayList<>();
    private static List<String> cleansedAnimals = new ArrayList<>();

    static void registerCleansingCenter(String name) {
        cleansingCenterMap.put(name, new Center(name));
    }

    public static void registerAdoptionCenter(String name) {
        adoptionCenterMap.put(name, new AdoptionCenter(name));
    }

    static void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, learnedCommands);
        adoptionCenterMap.get(adoptionCenterName).getAnimalList().add(dog);

    }

    static void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, intelligenceCoefficient);
        adoptionCenterMap.get(adoptionCenterName).getAnimalList().add(cat);

    }

    static void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {

        List<Animal> animalsToDeleteAfterStream = new ArrayList<>();

        adoptionCenterMap.get(adoptionCenterName).getAnimalList().forEach(s -> {
            if (!s.cleanStatus) {
                s.setOldCenterName(adoptionCenterName);
                cleansingCenterMap.get(cleansingCenterName).getAnimalList().add(s);
                animalsToDeleteAfterStream.add(s);
            }
        });

        for (Animal animal : animalsToDeleteAfterStream) {
            adoptionCenterMap.get(adoptionCenterName).getAnimalList().remove(animal);
        }
    }

    static void cleanse(String cleansingCenterName) {

        List<Animal> animalsToDeleteAfterStream = new ArrayList<>();

        cleansingCenterMap.get(cleansingCenterName).getAnimalList().forEach(a -> {

            a.setCleanStatus(true);
            cleansedAnimals.add(a.getName());
            adoptionCenterMap.get(a.getOldCenterName()).getAnimalList().add(a);


        });

        for (Animal animal : animalsToDeleteAfterStream) {
            cleansingCenterMap.get(cleansingCenterName).getAnimalList().remove(animal);
        }

    }

    static void adopt(String adoptionCenterName) {

        List<Animal> animalsToDeleteAfterStream = new ArrayList<>();

        adoptionCenterMap.get(adoptionCenterName).getAnimalList().forEach(e -> {

            if (e.getCleanStatus()) {
                adoptedAnimals.add(e.getName());
                animalsToDeleteAfterStream.add(e);
            }


        });

        for (Animal animal : animalsToDeleteAfterStream) {
            adoptionCenterMap.get(adoptionCenterName).getAnimalList().remove(animal);
        }
    }

    static void printStatistics() {

        System.out.println("Paw Incorporative Regular Statistics");
        System.out.printf("Adoption Centers: %d%n", adoptionCenterMap.size());
        System.out.printf("Cleansing Centers: %d%n", cleansingCenterMap.size());
        System.out.print("Adopted Animals: ");
        Collections.sort(adoptedAnimals);
        System.out.print(String.join(", ", adoptedAnimals));
        System.out.println();
        System.out.print("Cleansed Animals: ");
        Collections.sort(cleansedAnimals);
        System.out.print(String.join(", ", cleansedAnimals));
        System.out.println();
        List<Animal> animalsAwaitingAdoption = new ArrayList<>();

        adoptionCenterMap.entrySet().forEach(e -> {

            for (Animal animal : e.getValue().getAnimalList()) {
                if (animal.getCleanStatus()) {
                    animalsAwaitingAdoption.add(animal);
                }
            }
        });

        adoptionCenterMap.entrySet().forEach(e -> e.getValue().getAnimalList().forEach(a -> System.out.printf("%s ", a.getName())));

        System.out.printf("Animals awaiting adoption: %d%n", animalsAwaitingAdoption.size());
        List<Animal> animalsAwaitingCleansing = new ArrayList<>();
        for (Map.Entry<String, Center> stringCenterEntry : cleansingCenterMap.entrySet()) {
            stringCenterEntry.getValue().getAnimalList().forEach(e -> {

                if (!e.getCleanStatus()) {
                    animalsAwaitingCleansing.add(e);
                }

            });
        }

        System.out.print("Animals awaiting cleansing: " + animalsAwaitingCleansing.size());
    }


}
