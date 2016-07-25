package org.academiadecodigo.sniperelite;

import sun.security.krb5.internal.crypto.Des;

import java.util.Objects;

/**
 * Created by codecadet on 17/05/16.
 */
public class Game {

    private GameObject[] gameObjects;
    SniperRifle sniperRifle = new SniperRifle();
    private int shotsFired;


    public int getShotsFired() {
        return shotsFired;
    }

    public GameObject[] createObjects(int numberObjects) {

        gameObjects = new GameObject[numberObjects];

        for (int i = 0; i < gameObjects.length; i++) {

            switch (Random.get(6)){
                case 0:case 1: gameObjects[i] = new ArmouredEnemy();
                    break;
                case 2:case 3:case 4: gameObjects[i] =  new SoldierEnemy();
                    break;
                case 5: gameObjects[i] =  new Tree();
                    break;
                case 6: gameObjects[i] = new Barrel(Barrel.getRandomType());
                default:
                    break;
            }

        }

        return gameObjects;
    }

    public void start(int numberOfObjects) {

        createObjects(numberOfObjects);

        for (int i = 0; i < gameObjects.length; i++) {


            if(gameObjects[i] instanceof Destroyable){

                Destroyable target = (Destroyable) gameObjects[i];

                while(!target.isDestroyed()){

                    sniperRifle.shoot(target);
                    shotsFired++;

                }
                System.out.println(gameObjects[i].getMessage());
            }


            if(gameObjects[i] instanceof Tree){
                System.out.println(gameObjects[i].getMessage());
            }

        }
        System.out.println(getShotsFired());

    }

}
