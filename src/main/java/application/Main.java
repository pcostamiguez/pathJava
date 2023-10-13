package application;

import entities.BusinessAccount;

public class Main {
    public static void main(String[] args) {
        BusinessAccount bus1 = new BusinessAccount(100, "Pedro", 100000.0, 5000.0);
        try {
            bus1.withdraw(50000.0, 1000);
            System.out.println(bus1.getBalance());
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
