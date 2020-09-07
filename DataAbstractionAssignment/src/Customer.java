import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<Deposit>();
    private ArrayList<Withdraw> withdraws = new ArrayList<Withdraw>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    private double checkDeposit;
    private double savingDeposit;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer() {
        //create default constructor
        name = "Bob";
        accountNumber = 1;
        checkDeposit = 50;
        savingDeposit = 100;
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit) {
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance += checkDeposit;
        this.savingBalance += savingDeposit;
    }

    //Requires: double, Date, and String
    //Modifies: this
    //Effects: deposits amount in to either the checking account or saving account, depending on which account is specified
    public double deposit(double amt, Date date, String account) {
        //your code here
        if (account.equals(CHECKING)) {
            checkBalance += amt;
        } else if (account.equals(SAVING)) {
            savingBalance += amt;
        }
        Deposit d = new Deposit(amt, date, account);
        deposits.add(d);
        return 0;
    }

    //Requires: double, Date, and String
    //Modifies: this
    //Effects: withdraws amount from either the checking account or saving account, depending on which account is specified
    public double withdraw(double amt, Date date, String account) {
        //your code here
        if (account.equals(CHECKING)) {
            checkOverdraft(amt, account);
            checkBalance -= amt;
        } else if (account.equals(SAVING)) {
            checkOverdraft(amt, account);
            savingBalance -= amt;
        }
        Withdraw w = new Withdraw(amt, date, account);
        withdraws.add(w);
        return 0;
    }

    private boolean checkOverdraft(double amt, String account) {
        //your code here
        if (account.equals(CHECKING)) {
            if (amt > (checkBalance - OVERDRAFT)) {
                return false;
            } else {
                return true;
            }
        }
        if (account.equals(SAVING)) {
            if (amt > (savingBalance - OVERDRAFT)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

        //do not modify
        public void displayDeposits() {
            for (Deposit d : deposits) {
                System.out.println(d);
            }
        }
        //do not modify
        public void displayWithdraws() {
            for (Withdraw w : withdraws) {
                System.out.println(w);
            }
        }

    public double getCheckBalance() {
        return checkBalance;
    }

    public void setCheckBalance(double checkBalance) {
        this.checkBalance = checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public String getDeposit() {
        return deposits.toString();
    }
    public String getWithdraw() {
        return withdraws.toString();
    }
}



