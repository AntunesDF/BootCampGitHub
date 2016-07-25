package org.academiadecodigo.sniperelite;

/**
 * Created by codecadet on 17/05/16.
 */
public class ArmouredEnemy extends Enemy {

    private int armour = 50;


    public void hit(int damage) {

        if (armour > 0) {
            armour = armour - damage;
            if(armour < 0){
                setHealth(getHealth() + armour);
            }
        } else {
            setHealth(getHealth() - damage);
        }

        if (getHealth() <= 0) {
            setDead(true);
        }
    }

    public String getMessage(){
        return "Fck my armour!";
    }
}
