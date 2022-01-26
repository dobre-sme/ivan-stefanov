package Jan25.AndreyAndBilliard07;

import java.util.Map;

public class Customer {
    String name;
    Map<String, Integer> buyList;
    double bill;

    public Customer(String name, Map<String, Integer> buyList, double bill) {
        this.name = name;
        this.buyList = buyList;
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getBuyList() {
        return buyList;
    }

    public void setBuyList(Map<String, Integer> buyList) {
        this.buyList = buyList;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }
}
