import java.util.Random;

public class BankAccount{
    String accountNumber="";
    double checkingBalance;
    double savingsBalance;
    public static int numberOfAccounts=0;
    public static double totalBalance=0;

    public BankAccount(double checkingBalance){
        this.accountNumber = generateAccountNumber();
        this.checkingBalance=checkingBalance;
        totalBalance += checkingBalance;
        numberOfAccounts +=1;
    }

    public BankAccount(double checkingBalance, double savingsBalance){
        this.accountNumber = generateAccountNumber();
        this.checkingBalance=checkingBalance;
        this.savingsBalance=savingsBalance;
        totalBalance = totalBalance+savingsBalance+checkingBalance;

    }

    private String generateAccountNumber(){
        Random rand= new Random();
        String genereatedNumber="";
        for (int i=1; i<=10; i++){
            int temp= rand.nextInt(9);
            genereatedNumber += String.valueOf(temp);
        }
        return genereatedNumber;
    }

    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance=checkingBalance;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance=savingsBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void depositMoney(double amount){
        checkingBalance += amount;
        totalBalance +=amount;
        System.out.println(amount +"is deposited in to your account, Your Total balance is: "+checkBalance());
    }

    public void withdrawMoney(double amount){
        checkingBalance -= amount;
        totalBalance -=amount;
        System.out.println(amount +"is deposited in to your account, Your Total balance is: "+checkBalance());
    }

    public double checkBalance(){
        return totalBalance;
    }
}