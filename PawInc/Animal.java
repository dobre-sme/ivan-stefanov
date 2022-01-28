package PawInc;

public class Animal {
     String name;
     int age;
     boolean cleanStatus = false;
     String adoptionCenterName;

    public String getAdoptionCenterName() {
        return adoptionCenterName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCleanStatus(boolean cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    public boolean getCleanStatus(){
        return cleanStatus;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
