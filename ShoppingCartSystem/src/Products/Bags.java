package Products;

import ProductRepository.Product;

public class Bags extends Product {

    public Bags(String color , double price){
        super(color,price);
    }

    @Override
    public String getProductType() {
        return "Bag";
    }

}
