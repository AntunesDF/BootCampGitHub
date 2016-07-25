package org.academiadecodigo.money;

/**
 * Created by codecadet on 10/05/16.
 */
public class Bank {

    private int cash;

    public int getCash() { return this.cash; }

    public void setCash(int cash) { this.cash = cash; }



    public int withdrawal(int cash){
        this.cash -= cash;
        return cash;
    }

    public int deposit(int cash){
        this.cash += cash;
        return cash;
    }
}