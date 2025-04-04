package Products;

import ProductRepository.Product;

public class Clothes extends Product {
    public Clothes(String color , double price){
        super(color, price);
    }

    @Override
    public String getProductType() {
        return "Clothes";
    }
}
