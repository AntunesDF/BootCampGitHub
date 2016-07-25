package org.academiadecodigo.sniperelite;

/**
 * Created by codecadet on 17/05/16.
 */
public class SoldierEnemy extends Enemy{

    public void hit(int damage){

        setHealth(getHealth() - damage);

        if(getHealth() <= 0){
            setDead(true);
        }
    }

    public String getMessage(){
        return "Ahhhh, mataram-me!";
    }
}
