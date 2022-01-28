package PawInc;

public class Dog extends Animal{

    private int commands;

    public Dog(String name, int age, int num) {
        super(name, age);
        this.commands = num;
    }

    public int getCommands() {
        return commands;
    }

    public void setCommands(int commands) {
        this.commands = commands;
    }
}
