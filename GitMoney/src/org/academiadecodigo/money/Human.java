package org.academiadecodigo.money;

/**
 * Created by codecadet on 10/05/16.
 */
public class Human {

    private int cash;

    public int getCash(){
        return this.cash;
    }

    public void setCash(int cash) { this.cash = cash; }



    public void withdrawal(Bank bank, int cash){
        this.cash += bank.withdrawal(cash);
    }

    public void withdrawal(Wallet wallet, int cash){
        this.cash += wallet.withdrawal(cash);
    }



    public void deposit(Bank bank, int cash){
        this.cash -= bank.deposit(cash);
    }

    public void deposit(Wallet wallet, int cash){
        this.cash -= wallet.deposit(cash);
    }


    public void payUp (Shop shop, int cash){
        this.cash -= shop.payUp(cash);
    }
}
