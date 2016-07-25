package org.academiadecodigo.genie;

/**
 * Created by codecadet on 12/05/16.
 */
public class MagicLamp {

    public int maxNumbGenies = 6;

    public int numberOfGenies = 6;

    public int numberOfRecycles = 0;


    public Genie rubLamp(){

        Genie genie;

        if(numberOfGenies > 1){
            numberOfGenies--;

            Random.random();

            if(Random.random() == 0){
                System.out.println("Congratulations! A happy genie is here for you.");
                genie = new HappyGenie();
                return genie;
            }
            else{
                System.out.println("You suck. You got a crappy genie...");
                genie = new SadGenie();
                return genie;
            }
        }
        else if(numberOfGenies == 1){
            numberOfGenies--;
            System.out.println("You have awoken the Awesome Demon of PowerWishes!");
            genie = new Demon();
            return genie;
        }
        else{
            System.out.println("You don't have any more genies. Recycle your Awesome Demon of PowerWishes!");
        }
        return null;
    }


    public void rechargeLamp(Demon demon){

        demon.setRecycleStatus(true);
        numberOfGenies = 6;
        numberOfRecycles++;
        System.out.println("The Awesome Demon of PowerWishes is out of magic juice. It shall be sacrificed for the greater good.");
        System.out.println("Your lamp has been magically recharged!");

    }


    public String compareLamps(MagicLamp lamp){
        if(lamp.maxNumbGenies == this.maxNumbGenies){
            System.out.println("Your lamps have the capacity for " + maxNumbGenies + " genies.");
        }
        else{
            System.out.println("Your lamps have different genie capacities.");
        }


        if(lamp.numberOfGenies == this.numberOfGenies){
            System.out.println("Your lamps have " + numberOfGenies + " genies left.");
        }
        else{
            System.out.println("Your lamps don't have the same amount of genies.");
        }


        if(lamp.numberOfRecycles == this.numberOfRecycles){
            System.out.println("Your lamps have been recycled" + numberOfRecycles + " times.");
        }
        else{
            System.out.println("Your lamps have been recycled different times. Nasty demons.");
        }

/*
        if(lamp.maxNumbGenies == this.maxNumbGenies && lamp.numberOfGenies == this.numberOfGenies && lamp.numberOfRecycles == this.numberOfRecycles){
            return true;
        }
        else{
            return false;
        }
*/
    return null;
    }
}
