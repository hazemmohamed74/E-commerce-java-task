package model;
import interfaces.Expirable;
import interfaces.shippable;
import java.time.LocalDate;

//as the required in the task it use the expriable and shippable 
public class Cheese extends Product implements Expirable, shippable  {

    private Double weight;
    private LocalDate expiryDate;    //we make them private as the willnot be access and intiallize througthvthe constractor only

    //our primirtive constractor 
    public Cheese(String name, double price, int quantity, LocalDate expiryDate, double weight)
 {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }
@Override
public boolean isExpired(){
    return LocalDate.now().isAfter(expiryDate);

}
@Override
    public Double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
    
}
