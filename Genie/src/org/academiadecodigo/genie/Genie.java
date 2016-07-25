package org.academiadecodigo.genie;

/**
 * Created by codecadet on 12/05/16.
 */
public class Genie {

    public int numberOfWishes = 3;

    public void wish(){

        if (numberOfWishes == 0){
            System.out.println("You don't have any more wishes, b1tch!");
        } else{
            numberOfWishes--;
            System.out.println("Your wish has been granted!");
        }
    }
}
