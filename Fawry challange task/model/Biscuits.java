package model;

import interfaces.Expirable;
import java.time.LocalDate;

public class Biscuits extends Product implements Expirable {
    private LocalDate expiryDate;

    public Biscuits(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
    @Override
public boolean canBeSold() {
    return !isExpired(); // default
}
}
