package test1;

import java.util.Date;

public class Expirableproduct extends Product implements Expirable{
    private Date expiryDate;

    public Expirableproduct(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public Date getExpiryDate() {

        return expiryDate;
    }

    @Override
    public boolean isExpired() {

        return new Date().after(expiryDate);
    }
}
