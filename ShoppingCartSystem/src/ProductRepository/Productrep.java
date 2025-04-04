package ProductRepository;

import Products.Bags;
import Products.Clothes;
import Products.Jewlery;
import Products.Shoes;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Productrep {

    public static List<Product> cartitems = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);


    //Validate input

    public static int getValidInteger(String prompt){
        while(true){
            System.out.print(prompt);
            try{
                return scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                scan.next();
            }
        }
    }
    public static double getvalidDouble(String prompt) {
        while (true) { //While app instance is running
            System.out.print(prompt);
            try {
                return scan.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input");
                scan.next();
            }
        }
    }
    public static String getValidString(String prompt){
        while(true){
            System.out.print(prompt);
            try {
                return scan.next();
            } catch (Exception e) {
                System.out.println("Invalid input");
                scan.next();
            }
        }
    }
    public static int getValidBounds(String prompt) {

        int val;
        val = getValidInteger(prompt);
        if (val < 0 || val >= cartitems.size()+1) {
            System.out.println("Index out of bounds");
        }
        return val;
    }



    //ProductInitializer
    public static Product initializeProduct(int value){
        String color = getValidString("Enter desired product color:");
        double price = getvalidDouble("Enter a suitable price:");
        Product productval = null;
        switch (value){
            case (1):
                productval = new Bags(color,price);
                break;
            case(2):
                productval = new Shoes(color,price);
                break;
            case(3):
                productval = new Clothes(color,price);
                break;
            case(4):
                productval = new Jewlery(color,price);
                break;
            default:
                return null;
        }
        return productval;
    }



    //Menu Actions
    public static void addItem(){
        while(true){
            int choose = getValidInteger("Items available:\n 1.Bags \n 2.Shoes \n 3.Clothes \n 4.Jewlery  \n 5.go back to menu: ");
            if(choose == 5){break;}
            switch (choose){
                /* i made a mistake here before i called the initializeproducr() method and also wrote "cartitems.add(initializeProduct());"
                 * hence making the code ask me for the color and price twice */
                case (1):
                    cartitems.add(initializeProduct(1));
                    break;
                case(2):
                    cartitems.add(initializeProduct(2));
                    break;
                case(3):
                    cartitems.add(initializeProduct(3));
                    break;
                case(4):
                    cartitems.add(initializeProduct(4));
                    break;
            }
        }
    }
    public static void displayandcheckoutitems(){
        double total=0;
        System.out.println("product type     Color     price");
        for(Product items: cartitems){
            System.out.println(items.getProductType()+"     "+items.color+"     "+items.price);
            total+= items.price;
        }
        while(true) {
            String descision = getValidString("The total is " + total + " would you like to checkout(yes/no)?");
            if (descision.equalsIgnoreCase("yes")) {
                cartitems.clear();
                System.out.println("successfully paid $" + total + " , Thank you for shopping with us");
                break;
            } else {
                System.out.println("Invalid input");
            }
        }



    }
    public static void removeItem(){
        System.out.println("producttype        Color       price");
        for(Product items: cartitems){
            System.out.println(items.getProductType()+"     "+items.color+"     "+items.price);
        }
        int indexno = getValidBounds("Enter the position of the product you want to remove:");
        String indexval = cartitems.remove(indexno-1).getProductType();
        System.out.println("Successfully removed "+indexval);
    }
    public static void updateItemDescription(){
        System.out.println("producttype        Color       price");
        for(Product items: cartitems){
            System.out.println(items.getProductType()+"     "+items.color+"     "+items.price);
        }
        int indexno = getValidBounds("Enter the position of the product you want to update:");
        String newcolor = getValidString("Enter the new color of preference: ");
        double newprice = getvalidDouble("Enter the new price of preference:");
        Product item = cartitems.get(indexno-1);
        item.color = newcolor;
        item.price = newprice;
        System.out.println("Successfully updated "+item.getProductType()+" at position "+indexno);
        for(Product items: cartitems){
            System.out.println(items.getProductType()+"     "+items.color+"     "+items.price);
        }

    }
    public static void fetchCartItem(){
        String cartitem = getValidString("Enter the product type you are looking for: ");
        for(Product items:cartitems){
            if(cartitem.equalsIgnoreCase(items.getProductType())){
                System.out.println(items.getProductType()+"     "+items.color+"     "+items.price);
            }

        }
    }



}
