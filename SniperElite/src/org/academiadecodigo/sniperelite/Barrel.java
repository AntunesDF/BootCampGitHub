package org.academiadecodigo.sniperelite;

/**
 * Created by codecadet on 18/05/16.
 */
public class Barrel extends GameObject implements Destroyable {

    public BarrelType barrelType;
    public int currentDamage = 0;
    public boolean destroyed;


    public Barrel(BarrelType barrelType) {
        this.barrelType = barrelType;
    }


    public boolean isDestroyed() {
        return destroyed;
    }


    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }


    public void hit(int damage) {
        currentDamage = currentDamage + damage;

        if (currentDamage == barrelType.getMaxDamage()) {
            setDestroyed(true);
        }
    }


    public String getMessage() {
        return "CABUUUM!";
    }


    public static BarrelType getRandomType() {

        BarrelType barrelType;

        if (Random.getByInterval(1, 3) == 1) {
            barrelType = BarrelType.PLASTIC;
        } else if (Random.getByInterval(1, 3) == 2) {
            barrelType = BarrelType.WOOD;
        } else {
            barrelType = BarrelType.METAL;
        }

        return barrelType;
    }
}
