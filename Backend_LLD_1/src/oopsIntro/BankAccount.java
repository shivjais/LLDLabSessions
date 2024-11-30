package oopsIntro;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private String ownerName;

    private List<String> transactions = new ArrayList<>();

    public BankAccount(){

    }
    public BankAccount(double balance, String ownerName){
        this.balance=balance;
        this.ownerName=ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance >0){
            this.balance = balance;
        }

    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if(ownerName != "" && ownerName !=  null){
            this.ownerName = ownerName;
        }
    }

    public void deposit(int amount){
        if(amount >0){
            balance += amount;
            transactions.add("Deposited $"+amount);
        }
    }
    public  void withdraw(int amount){
        if(balance > 0 && balance >= amount){
            balance -= amount;
            transactions.add("withdraw $"+amount);
        }
    }
    public void printTransactionHistory(){
        System.out.println(transactions);
    }
}
