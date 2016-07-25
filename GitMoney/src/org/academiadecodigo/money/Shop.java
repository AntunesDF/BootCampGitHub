package org.academiadecodigo.money;

/**
 * Created by codecadet on 10/05/16.
 */
public class Shop {

    private int cash;

    public int getCash() { return this.cash; }

    public void setCash(int cash) { this.cash = cash; }



    public void withdrawal(Bank bank, int cash){
        this.cash += bank.withdrawal(cash);
    }

    public void deposit(Bank bank, int cash){
        this.cash -= bank.deposit(cash);
    }


    public int payUp(int cash){
        this.cash += cash;
        return cash;
    }
}
