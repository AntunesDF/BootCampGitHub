/**
 * Created by codecadet on 10/05/16.
 */
public class Generator {
    public static int random() {
        return (int)(Math.random());
    }

    public float hand = Generator.random();
    public String handy;


    if (hand < 0.3) {
        handy = PlayerHand.ROCK;
    } else if (0.3 <= hand < 0.6) {
        handy = PlayerHand.PAPER;
    } else {
        handy = PlayerHand.SCISORS;
    }

    return handy;

}
