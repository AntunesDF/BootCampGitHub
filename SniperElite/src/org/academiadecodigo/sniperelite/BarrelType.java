package org.academiadecodigo.sniperelite;

/**
 * Created by codecadet on 18/05/16.
 */
public enum BarrelType {
    PLASTIC(10),
    WOOD(20),
    METAL(30);

    private int maxDamage;

    public int getMaxDamage(){
        return maxDamage;
    }

    BarrelType(int maxDamage) {
        this.maxDamage = maxDamage;
    }
}
