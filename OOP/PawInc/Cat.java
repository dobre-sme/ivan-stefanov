package PawInc;

public class Cat extends Animal{
   private int IQ;

    public Cat(String name,int age, int num, String adoptionCenterName) {
        super(name, age);
        this.IQ = num;
        this.adoptionCenterName = adoptionCenterName;
    }

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int IQ) {
        this.IQ = IQ;
    }
}
