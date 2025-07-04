package model;
import java.util.ArrayList;
import java.util.List;

import interfaces.Expirable;
import interfaces.shippable;
import service.ShippingService;

public class Customer {
    private String name;
    private double balance;
    private List<CartItem> cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new ArrayList<>();
    }
// the first method to add to the cart 
    public void addToCart(Product product, int quantity) {
        if (!product.isAvailable(quantity)) {
            System.out.println(" Not enough stock for: " + product.getName());
            return;
        }
        cart.add(new CartItem(product, quantity));
        System.out.println(" Added " + quantity + "x " + product.getName() + " to cart.");
    }

    //3ayzen n3ml checkout 
    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Cannot checkout.");
            return;
        }
        double subtotal = 0;
        double shippingFees = 0;
        List<shippable> itemsToShip = new ArrayList<>();
        for (CartItem item : cart) {
            Product product = item.getProduct();
            int qty = item.getQuantity();

            //  Check lw mwgood aw  l2
            if (!product.isAvailable(qty)) {
                System.out.println(" Product out of stock: " + product.getName());
                return;
            }
            // check lw expired or not
            if (product instanceof Expirable) {
                Expirable exp = (Expirable) product;
                if (exp.isExpired()) {
                    System.out.println(" Product expired: " + product.getName());
                    return;
                }
            }

            subtotal += item.getTotalPrice();

              //check for shipping
            if (product instanceof shippable) {
                shippable shippable = (shippable) product;
                itemsToShip.add(shippable);
                shippingFees += shippable.getWeight() ; 
            }
        }

        double total = subtotal + shippingFees;

        if (balance < total) {
            System.out.println(" Insufficient balance. Needed: $" + total + ", Available: $" + balance);
            return;
        }

        //payment
        for (CartItem item : cart) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        balance -= total;

        if (!itemsToShip.isEmpty()) {
            ShippingService.shipItems(itemsToShip);
        }

        cart.clear();
    }
}
