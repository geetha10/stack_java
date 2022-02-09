import  java.util.ArrayList;

public class CafeUtil{
    public int getStreakGoal(int numWeeks){
        int sum=0;
        for(int i=0; i<= numWeeks;i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double total=0;
        for(double price: prices){
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems){
        int count=1;
        for(String item: menuItems){
            System.out.println(count+ ". " +item);
            count++;
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName=System.console().readLine();
        System.out.println("Hello, " + userName+"!"+" There are "+ customers.size()+" people are ahed of you.");
        customers.add(userName);
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        for(int i=1; i<= maxQuantity; i++){
            if(i>1){
                System.out.println(i+" - $"+ (i*price-(i-1)*0.5));
            }
            else{
                System.out.println(i+" - $"+i*price);
            }
        }
    }

    public void displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){

        if(menuItems.size() == prices.size()){
            for(int i=0; i< prices.size(); i++){
                System.out.println(i+" "+menuItems.get(i)+" -- $"+prices.get(i));
            }
        }
        else{
            System.out.println("Size of array are not equal");
        }
    }
}