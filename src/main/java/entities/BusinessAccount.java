package entities;

public final class BusinessAccount extends Account {
    private double loanLimit;

    public void loan(double amount){
        double tax = 10.0;
        if(amount > 0){
            if (amount <= loanLimit){
                deposit(amount - tax);
            }else{
                throw new IllegalArgumentException("O valor a ser emprestado não pode ser maior do que o limite.");
            }
        }else{
            throw new IllegalArgumentException("Insira um valor maior do que zero.");
        }
    }

    @Override
    public void withdraw(double amount){
        super.withdraw(amount); //O super chama a classe pai. Nesse caso usamos o método da classe pai.
        balance -= 10.0;
    }

    //Override (Sobrescrita de método. A anotação @Override informa ao compilador a sobrescrita, sendo assim uma boa prática.)
//    @Override
//    public void withdraw(double amount){
//        if(amount > 0 && (amount + 10.0) <= balance){
//            balance -= amount + 10.0;
//        }else{
//            throw new IllegalArgumentException("Saldo insulficiente.");
//        }
//    }

    //Overloading (Sobrecarga de método)
    public void withdraw(double amount, double tax){
        if(amount > 0 && (amount + tax) <= balance){
            balance -= amount + tax;
        }else{
            throw new IllegalArgumentException("Saldo insulficiente.");
        }
    }

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(int number, String holder, double balance, double loanLimit) {
        super(number, holder, balance); //chama o construtor da classe pai (Account)
        this.loanLimit = loanLimit;
    }

    public double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }
}
