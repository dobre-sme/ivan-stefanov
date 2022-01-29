package PawInc;

public class Dog extends Animal{

    private int commands;

    public Dog(String name, int age, int commands, String adoptionCenterName) {
        super(name, age);
        this.commands = commands;
        this.adoptionCenterName = adoptionCenterName;
    }

    public int getCommands() {
        return commands;
    }

    public void setCommands(int commands) {
        this.commands = commands;
    }
}
