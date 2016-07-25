package org.academiadecodigo.sniperelite;

/**
 * Created by codecadet on 17/05/16.
 */
public class Random {

    public static int get(int i) {
        return getByInterval(0, i);
    }

    public static int getByInterval(int i, int j) {

        return (int) (i + (Math.random() * (j - i + 1)));
    }

}
