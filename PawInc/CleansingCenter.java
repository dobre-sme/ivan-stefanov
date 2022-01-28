package PawInc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CleansingCenter extends Center{

    public CleansingCenter(String name) {
        super(name);
    }

    private static Map<String,List<Animal>> cleansingCenters = new HashMap<>();

    private static List<String> cleansedAnimals = new ArrayList<>();

    public static List<String> getCleansedAnimals() {
        return cleansedAnimals;
    }

    public static Map<String, List<Animal>> getCenters() {
        return cleansingCenters;
    }

    public static void registerCleansingCenter(String name) {
        cleansingCenters.put(name, new ArrayList<>() );
    }
    public static void cleanse(String cleansingCenterName){
        for (Animal animal : cleansingCenters.get(cleansingCenterName)) {
            animal.setCleanStatus(true);
            cleansedAnimals.add(animal.getName());
            AdoptionCenter.getAdoptionCenters().get(animal.getAdoptionCenterName()).add(animal);
        }
        cleansingCenters.get(cleansingCenterName).clear();
    }

    public static int animalsAwaitingCleaning(){
        int count = 0;
        for (List<Animal> value : cleansingCenters.values()) {
            count += value.size();
        }
        return count;
    }




}
