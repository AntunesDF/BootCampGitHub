package org.academiadecodigo.genie;

/**
 * Created by codecadet on 12/05/16.
 */
public class Demon extends Genie {

    private boolean recycleStatus = false;

    public void setRecycleStatus(boolean recycleStatus) {
        this.recycleStatus = recycleStatus;
    }

    @Override
    public void wish(){

        if(!recycleStatus){
            System.out.println("Your wish has been granted!");
        }
        else{
            System.out.println("The Awesome Demon of PowerWishes can no longer grant wishes.");
            System.out.println("It has been sacrificed!");
        }

    }
}
