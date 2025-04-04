package ProductRepository;

import java.util.ArrayList;
import java.util.List;


public abstract class Product {
    public String color;
    public double price;

    public Product(String color, double price) {
        this.color = color;
        this.price = price;
    }

    public abstract String getProductType();

}
