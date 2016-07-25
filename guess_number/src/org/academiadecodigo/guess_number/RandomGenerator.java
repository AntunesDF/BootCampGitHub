package org.academiadecodigo.guess_number;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by codecadet on 06/05/16.
 */
public class RandomGenerator {

//   tentativa #1
//   private static int nextInt(){
//        return next(1);
//   }


    public static int random(int max) {
        return (int)(Math.random() * max + 1);
    }



}
