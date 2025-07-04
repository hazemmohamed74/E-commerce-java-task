// No 'package' line here


import model.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. Create sample products
        Cheese cheese = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(5), 0.4);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 3, LocalDate.now().plusDays(2), 0.7);
        ScratchCard scratchCard = new ScratchCard("Scratch Card", 50, 10);

        // 2. Create customer
        Customer customer = new Customer("Hazem", 1000);

        // 3. Add products to cart
        customer.addToCart(cheese, 2);        // 2 x 100 = 200
        customer.addToCart(biscuits, 1);      // 1 x 150 = 150
        customer.addToCart(scratchCard, 1);   // 1 x 50  = 50

        // 4. Perform checkout
        customer.checkout();
    }
}
