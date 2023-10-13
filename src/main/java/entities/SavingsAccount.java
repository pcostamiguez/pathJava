package entities;

public final class SavingsAccount extends Account {
    private double interestRate;

    public void updateBalance(){
        balance += balance * interestRate;
    }

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int number, String holder, double balance, double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
