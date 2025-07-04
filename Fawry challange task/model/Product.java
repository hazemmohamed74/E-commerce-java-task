package model;

//our class is protected becouse we will not acees an object directly from it 
public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    //our primitive constractor 
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    // to reduce the quantity of the product from the stock
    public void reduceQuantity(int amount){
        this.quantity -=amount ;
    }

    //mehods to check if there is avaliable quantity or not 
    public boolean isAvailable(int requestedQty){
        return quantity >= requestedQty ;

    }

    @Override
public String toString() {
    return name + " - $" + price + " - Qty: " + quantity;
}



}
