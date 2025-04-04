package Products;

import ProductRepository.Product;

public class Jewlery extends Product {
    public Jewlery(String color , double price){
        super(color, price);
    }

    @Override
    public String getProductType() {
        return "Jewlery";
    }
}
