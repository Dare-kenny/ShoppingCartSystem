package Application;

import ProductRepository.Product;
import ProductRepository.Productrep;
import Products.Bags;
import Products.Clothes;
import Products.Jewlery;
import Products.Shoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ShoppingCart{





    public void runapp(){
        System.out.println("Welcome to the online cart");
        while(true){
            int op = Productrep.getValidInteger("\n 1.add item \n 2.remove item \n 3.update item description \n 4.Search for item in cart \n 5.checkout: \n");
            if(op == 5){
                if(Productrep.cartitems.isEmpty()){
                    System.out.println("cart is empty");
                }
                Productrep.displayandcheckoutitems();
            }
            if(op>=1 || op<=4){

                switch (op){
                    case(1):
                            Productrep.addItem();
                            break;
                    case(2):
                        //removeItem
                        Productrep.removeItem();
                        break;
                    case(3):
                        //update itemDescription
                        Productrep.updateItemDescription();
                        break;
                    case(4):
                        //fetchCartItem
                        Productrep.fetchCartItem();
                        break;
                    case(5):
                        //displayandcheckoutitems
                        Productrep.displayandcheckoutitems();
                        break;

                }
            }

        }
    }
}
