import java.util.ArrayList;


public class TestBarista{

    public static void main(String[] args){

        ArrayList<Item> menu= new ArrayList<Item>();

        System.out.println("Welcome To Barista, Please enter your name:");
        String custName=System.console().readLine();
        Order cust1= new Order(custName);

        //Item menuItem=new Item();

        Item latte= new Item("Latte", 4.5);
        menu.add(latte);

        Item cappucino= new Item("Cappucino", 4.8);
        menu.add(cappucino);

        Item dripCoffe= new Item("Drip Coffee", 2.5);
        menu.add(dripCoffe);
        
        Item espresso= new Item("Espresso", 3.5);
        menu.add(espresso);

        System.out.println("This is our menu");
        Item.displayMenu(menu);

        cust1.addItem(latte);
        cust1.addItem(dripCoffe);

        cust1.display();
    }
}