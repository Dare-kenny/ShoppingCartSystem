package Products;

import ProductRepository.Product;

public class Shoes extends Product {
    public Shoes(String color , double price){
        super(color,price);
    }

    @Override
    public String getProductType() {
        return "Shoe";
    }
}
