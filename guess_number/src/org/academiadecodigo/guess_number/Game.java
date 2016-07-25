package org.academiadecodigo.guess_number;

/**
 * Created by codecadet on 06/05/16.
 */
public class Game {

    public static int systemNumb() {
        return RandomGenerator.random(10);
    }

    public static int guessPlayerNumb(){
        return Player.guessNumb();
    }




}
