import  java.util.ArrayList;

public class TestCafe{

    public static void main(String[] args){
        CafeUtil appTest = new CafeUtil();
        System.out.println(appTest.getStreakGoal(10));
        double price[] = {2.00, 3.50, 5.00, 6.50};
        System.out.println(appTest.getOrderTotal(price));
        ArrayList<String> menuItems = new ArrayList<String>();
        ArrayList<Double> menuPrices = new ArrayList<Double>();

        menuItems.add("Drip coffee");
        menuPrices.add(1.5);

        menuItems.add("Cappuccino");
        menuPrices.add(3.5);

        menuItems.add("Latte");
        menuPrices.add(4.5);

        menuItems.add("Mocha");
        menuPrices.add(3.5);


        appTest.displayMenu(menuItems);
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        appTest.printPriceChart("Columbian Coffee Grounds",15.0,3);
        appTest.displayMenu(menuItems,menuPrices);

    }
}