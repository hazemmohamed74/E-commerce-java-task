package service;

import interfaces.shippable;
import java.util.List;

public class ShippingService {
    public static void shipItems(List<shippable> items) {
        System.out.println("Shipping the following items:");
        for (shippable item : items) {
            System.out.println("- " + item.getName() + " (" + item.getWeight() + " kg)");
        }
        System.out.println(" All items sent to shipping service\n");
    }
}

