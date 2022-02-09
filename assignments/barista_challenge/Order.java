import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.

    public Order(){
        this.name="Guest";
        this.ready=false;
        this.items = new ArrayList<Item>();
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.

    public Order(String name){
        this.name=name;
        this.ready=false;
        this.items = new ArrayList<Item>();
    }
    
    // ORDER METHODS
    
    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    
    // GETTERS & SETTERS
    public void setName(String itemName){
        this.name=itemName;
    }

    public String getName(){
        return name;
    }

    public void setReady(boolean ready){
        this.ready=ready;
    }

    public boolean getReady(){
        return ready;
    }

    public void setItems(ArrayList items){
        this.items=items;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public boolean getStatusMessage(){
        return ready;
    }

    public double getOrderTotal(){
        double total=0;
        for (Item item: this.items){
            total += item.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.println("Customer Name: "+this.name);
        System.out.println(this.name+" Ordered the following:");
        for (Item item: items){
            System.out.println(item.getName()+" - $"+ item.getPrice());
        }
        System.out.println("Total: "+getOrderTotal());
    }    
}

