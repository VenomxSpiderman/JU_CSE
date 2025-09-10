import java.util.Scanner;
public class q7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the initial interest rate=");
        double r = sc.nextDouble();
        
        new BankAcct(r);
        //Anonymously creating an object of BankAcct class just to set the interest rate
        
        System.out.println("Enter account number and balance");
        long acct=sc.nextLong();
        double bal = sc.nextDouble();
        
        BankAcct bank=new BankAcct(acct,bal);
        while(true){
        System.out.println("Enter 1 for displaying balance\nEnter 2 for calculating interest\nEnter 3 for Displaying interest rate\nEnter 4 for changing interest rate\nEnter 5 for exit");
        int ch = sc.nextInt();
            
            if(ch==5){
                System.out.println("Bye");
                break;
            }
            switch (ch) {
                case 1->bank.display_balance();
                case 2->System.out.println("Interest="+bank.calc_interest());
                case 3->bank.display_interest();
                case 4->{
                    System.out.println("Enter new Interest Rate");
                    BankAcct.set_interest(sc.nextDouble());
                }
                
                default-> System.out.println("Wrong Choice");
                    
            }
    }

        sc.close();
    }
}
class BankAcct{
    @SuppressWarnings("unused")
    private long account;
    
    private double balance;
    
    static double interest;
    BankAcct(double interest_rate){
        account=0L;
        balance=0.0;
        interest=interest_rate;

    }

    BankAcct(long account, double balance) {
        this.account = account;
        this.balance = balance;
    }
    
    static void set_interest(double rate) {
        interest = rate;
    }
    
    void display_interest() {
        System.out.println("Interest rate=" + interest);
    }
    
    void display_balance() {
        System.out.println("Balance=" + balance);
    }
    
    double calc_interest(){
        return (interest*balance)/100;
    }

}
