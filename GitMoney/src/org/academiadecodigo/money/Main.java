package org.academiadecodigo.money;

/**
 * Created by codecadet on 10/05/16.
 */
public class Main {

    public static void main (String[] args) {


        Human human = new Human();

        Wallet wallet = new Wallet();

        Bank bank = new Bank();

        Shop shop = new Shop();

        Account account = new Account();

// ----------------------------------

        human.getCash();
        human.setCash(20);

        wallet.getCash();
        wallet.setCash(20);

        bank.getCash();
        bank.setCash(20);

        shop.getCash();
        shop.setCash(20);

        account.getCash();
        account.setCash(20);

// ----------------------------------

        human.withdrawal(bank, 10);

        human.withdrawal(wallet, 10);

        human.deposit(bank, 5);

        human.deposit(wallet, 5);

        shop.deposit(bank, 10);

        shop.withdrawal(bank, 5);

        human.payUp(shop, 10);


        System.out.println(human.getCash());
        System.out.println(bank.getCash());
        System.out.println(wallet.getCash());
        System.out.println(shop.getCash());
        System.out.println(account.getCash());

    }
}
