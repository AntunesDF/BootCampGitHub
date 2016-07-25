package org.academiadecodigo.genie;

/**
 * Created by codecadet on 12/05/16.
 */
public class Random {

    public static int random(){

        int math = (int) (Math.random() * (10) + 1);
        int i = checkRandom(math);
        return i;
    }

    public static int checkRandom(int math){

        if(math%2 == 0){
            return 1;
        }
        else{
            return 0;
        }
    }

}
