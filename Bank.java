class BankAccount{
    protected int accno;
    protected double balance;
    BankAccount(int accno,double balance){
        this.accno=accno;
        this.balance=balance;
    }
    public void deposit(double amount){
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount){
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public double displayBalance(){
        return balance;
    }
}
class SavingsAccount extends BankAccount{
    double interestRate;
    SavingsAccount(int accno,double balance,double interestRate){
        super(accno,balance);
        this.interestRate=interestRate;
    }
    public double addInterest(){
        double interest=super.balance*interestRate/100;
        return interest+super.balance;
    }
}
class CheckingAccount extends BankAccount{
    CheckingAccount(int accno,double balance){
        super(accno,balance);
    }
    double overdraftLimit=500;
    @Override
    public void withdraw(double amount){
        if(super.balance+overdraftLimit<=amount){
            System.out.println("Withdrawal: "+amount);
            System.out.println("Overdraft used: "+overdraftLimit);
        } else{
            System.out.println("Overdraft limit exceeded.");
        }
    }
}
class FDAccount extends BankAccount{
    private int termInYears;
    private double fdInterestRate;
    FDAccount(int accno,double balance,int termInYears,double fdInterestRate){
        super(accno,balance);
        this.termInYears=termInYears;
        this.fdInterestRate=fdInterestRate;
    }
    public void calculateMaturityAmount(){
        double maturity=super.balance+(super.balance*fdInterestRate*termInYears/100);
        System.out.println("Maturity Amount(after "+termInYears+" years at "+fdInterestRate+" %): "+maturity);
    }
}
public class Bank{
    public static void main(String[] args){
        System.out.println("Savings Account");
        SavingsAccount sa=new SavingsAccount(123,1000.0,5);
        System.out.println("Balance: "+sa.displayBalance());
        System.out.println("After interest: "+sa.addInterest());
        System.out.println("Checking Account"); 
        CheckingAccount ca=new CheckingAccount(125,2000.0);
        System.out.println("Balance: "+ca.displayBalance());
        ca.withdraw(2500.0);
        System.out.println("FD Account");
        FDAccount fd=new FDAccount(352,5000.0,2,6);
        System.out.println("Balance: "+fd.displayBalance());
        fd.calculateMaturityAmount();
    }
}