package org.academiadecodigo.genie;

/**
 * Created by codecadet on 12/05/16.
 */
public class Main {

    public static void main(String[] args) {

        MagicLamp[] lamps = new MagicLamp[2];
            for(int index = 0; index < lamps.length; index++){
                lamps[index] = new MagicLamp();
            }

//---------------------------------------------------------------------

        Genie genie = lamps[0].rubLamp();
        genie.wish();
        genie.wish();
        genie.wish();
        genie.wish();

        Genie genie1 = lamps[0].rubLamp();
        genie1.wish();
        genie1.wish();
        genie1.wish();
        genie1.wish();

        Genie genie2= lamps[0].rubLamp();
        genie2.wish();
        genie2.wish();
        genie2.wish();
        genie2.wish();

        Genie genie3 = lamps[0].rubLamp();
        genie3.wish();
        genie3.wish();
        genie3.wish();
        genie3.wish();

        Genie genie4 = lamps[0].rubLamp();
        genie4.wish();
        genie4.wish();
        genie4.wish();
        genie4.wish();

        Genie genie5 = lamps[0].rubLamp();
        genie5.wish();
        genie5.wish();
        genie5.wish();
        genie5.wish();
        genie5.wish();
        genie5.wish();
        genie5.wish();
        genie5.wish();
        genie5.wish();
        genie5.wish();

        Genie genie6 = lamps[0].rubLamp();

        Demon demon = (Demon)genie5;

        lamps[0].rechargeLamp(demon);

        genie5.wish();

        System.out.println(lamps[0].compareLamps(lamps[1]));


    }
}