import java.util.ArrayList;

public class Item {
    
    // MEMBER VARIABLES
    private String name;
    private double price;
    
    // CONSTRUCTOR
    //   Takes a name and price as arguments 
    //   and sets them accordingly

    public Item(){}

    public Item(String name,double price){
        this.name=name;
        this.price=price; 
    }
    
    // GETTERS & SETTERS  - for name and price

    public void setName(String itemName){
        this.name=itemName;
    }

    public String getName(){
        return name;
    }

    public void setPrice(double itemPrice){
        this.price=itemPrice;
    }

    public double getPrice(){
        return price;
    }

    public static void displayMenu(ArrayList<Item> menu){
    
        System.out.println("");
        for(Item item: menu){
            System.out.println(item.getName()+ " -- $"+item.getPrice());
        }
    }
    
}