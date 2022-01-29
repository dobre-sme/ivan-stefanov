package PawInc;

import java.util.List;

public class Center {
    private String name;
    private List<Animal> animalList;

    public Center(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }


}
