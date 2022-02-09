public class TestBankAccount{
    public static void main(String[] args){
        BankAccount account1=new BankAccount(1000.0);
        System.out.println(account1.checkBalance());
        System.out.println(account1.getAccountNumber());
    }
}