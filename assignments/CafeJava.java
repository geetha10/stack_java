public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 2.5;
        double latte = 4.5;
        double cappuccino = 4.5;
    

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;

    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if(isReadyOrder1){
            System.out.println(customer1 +" your order is ready. Your Total is "+dripCoffee);
            isReadyOrder2=true;
        }
        if(isReadyOrder2){
            System.out.println(customer2 +" your order is ready. Your Total is "+cappuccino);
            isReadyOrder3=true;
        }
        if(isReadyOrder3){
            System.out.println(customer1 +" your order is ready.Your Total is "+  2*latte);
            isReadyOrder4=true;
        }
        if(isReadyOrder4){
            System.out.println(customer1 +" your order is ready.Your Total is "+ (dripCoffee-latte));
        }
    }
}
