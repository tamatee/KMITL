package proFun.Lab12o;

import java.util.ArrayList;
//ผมส่งไฟล์driverไปเลยนะคับ
public class AcctList_650426 {
    public static void main(String[] args) {
        testAccount();
        testAcctList();
    }

    static void testAcctList() {
        ProFun12_AcctList clients = new ProFun12_AcctList();
        String startWith = "c";
        System.out.println("List of account name start with " + startWith.toUpperCase());
        System.out.println(clients.filterName(startWith.toUpperCase()));
        int bound = 1400;
        System.out.println("List of account balance less than " + bound);
        System.out.println(clients.balanceLessThan(bound));
    }

    static void testAccount() {
        ProFun12_Account acct1 = new ProFun12_Account(1, "melon", 1500);
        ProFun12_Account acct2 = new ProFun12_Account(2, "rose apple", 2200);
        System.out.println(acct1.credit(700)); // 2200
        System.out.println(acct2.debit(300)); // 1900
        System.out.println(acct1.transfer(acct2, 1000)); // 2200
        System.out.println(acct1.credit(-50)); // 1200
        System.out.println(acct2.debit(-50)); // 2900
        System.out.println(acct1); // total balance acct1
        System.out.println(acct2); // total balance acct2
    }
}

class ProFun12_AcctList {
    ArrayList<ProFun12_Account> acctList;

    ProFun12_AcctList() {
        acctList = new ArrayList<>();
        acctList.add(new ProFun12_Account(1, "Cactus", 1000)); //cactus
        acctList.add(new ProFun12_Account(2, "Celsia", 500)); // celsia
        acctList.add(new ProFun12_Account(3, "Clove pink", 1500));
        acctList.add(new ProFun12_Account(4, "Crown Imperial", 900));
        acctList.add(new ProFun12_Account(5, "Daffodil", 1200));
        acctList.add(new ProFun12_Account(6, "Daisy", 1700));
        acctList.add(new ProFun12_Account(7, "Dandelion", 500));
        acctList.add(new ProFun12_Account(8, "Dittany", 600));
    }
    ArrayList<ProFun12_Account> filterName(String c) {
        ArrayList<ProFun12_Account> result = new ArrayList<>();
        for(int i = 0;i < acctList.size();i++){
            if(acctList.get(i).getName().charAt(0) == c.charAt(0)){
                result.add(acctList.get(i));
            }   
        }
        return result;
    }

    ArrayList<ProFun12_Account> balanceLessThan(int b) {
        ArrayList<ProFun12_Account> result = new ArrayList<>();
        for(int i = 0;i < acctList.size();i++){
            if(acctList.get(i).getBalance() <= b){
                result.add(acctList.get(i));
            }   
        } 
        return result;
    }
}
class ProFun12_Account
{
    int id;
    String name;
    int balance;
    ProFun12_Account()
    {
        name = getName();
    }
    ProFun12_Account(int id, String name, int balance)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    int getID(int id)
    {
        return id;
    }
    String getName()
    {
        return this.name;
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
    int transfer(ProFun12_Account acct2, int amount)
    {
        if(this.balance >= amount)
        {
            this.balance -= amount;
            acct2.balance += amount;
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