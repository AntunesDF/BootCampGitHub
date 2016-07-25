package org.academiadecodigo.sniperelite;

/**
 * Created by codecadet on 17/05/16.
 */
public class SniperRifle {

    private int bulletDamage = 10;

    public void shoot(Destroyable destroyable){
        if(Random.get(9) > 3){
            destroyable.hit(bulletDamage);
        }
    }
}
