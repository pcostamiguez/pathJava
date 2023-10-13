package entities;

public abstract class Account {
    private int number;
    private String holder;
    protected double balance;

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
        }else{
            throw new IllegalArgumentException("Saldo insulficiente.");
        }
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }else{
            throw new IllegalArgumentException("Insira um valor maior do que zero.");
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public Account() {
    }

    public Account(int number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }
}
