package test1;

import java.util.Date;

public class ExpirableAndShippable extends Product implements Expirable, Shippable{
    private double weight;
    private Date expiryDate;

    public ExpirableAndShippable(String name, double price, int quantity, double weight, Date expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public Date getExpiryDate() {
        return null;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}

