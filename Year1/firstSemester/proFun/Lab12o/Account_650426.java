package proFun.Lab12o;

public class Account_650426 {
    public static void main(String[] args) {
        Account A1 = new Account(1, "Mor", 1000);
        Account A2 = new Account(2, "Test", 0);
        A1.transferTo(A2, 500);
        System.out.println(A1);
        System.out.println(A2);
    }
}
/**
 * Account
 */
class Account {
    String name;
    int id;
    int balance = 0;
    Account(int id, String name, int balance)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    int getID(int id)
    {
        return id;
    }
    String getName(String name)
    {
        return name;
    }
    int getBalance()
    {
        return balance;
    }
    int credit(int amount)
    {
        return balance += amount;
    }
    int debit(int amount)
    {
        if(balance >= amount) return balance - amount;
        else return balance;
    }
    int transferTo(Account Account_650426, int amount)
    {
        if(this.balance >= amount)
        {
            this.balance -= amount;
            Account_650426.balance += amount;
        }
        else
        {
            System.out.println("Insufficient Balance");
        }
        return getBalance();
    }
    public String toString() {
        return String.format("Account %s(%d) balance is %d", name, id, balance);
    }
}
