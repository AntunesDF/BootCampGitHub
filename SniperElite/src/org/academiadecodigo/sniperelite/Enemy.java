package org.academiadecodigo.sniperelite;

/**
 * Created by codecadet on 17/05/16.
 */
public abstract class Enemy extends GameObject implements Destroyable{

    private int health = 50;
    private boolean dead;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isDead(){
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDestroyed(){
        return isDead();
    }

    public abstract void hit(int damage);

    public abstract String getMessage();

}
