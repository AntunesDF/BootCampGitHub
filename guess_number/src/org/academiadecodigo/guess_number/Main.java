package org.academiadecodigo.guess_number;

import javax.xml.bind.SchemaOutputResolver;


/**
 * Created by codecadet on 06/05/16.
 */
public class Main {


    public static void main(String[] args) {

        int numbPlayers = 3;

        Player[] player = new Player[numbPlayers];

        for(int i = 0; i <= player.length; i++){
            player[i] = new Player();
        }


        System.out.println(Game.systemNumb());
        System.out.println(Game.guessPlayerNumb());


    }

}
