/**
 * Created by codecadet on 09/05/16.
 */
public class Game {

    private int maxGuess = 10;
    private Player[] players;

    public Game(Player[] players) {
        this.players = players;
    }

    public void start() {

        int systemGuess = guess();

        for (Player player: players) {
           if (systemGuess == player.guess(maxGuess)) {
               System.out.println("We have a winner!!!");
           };
        }

    }

    private int guess() {

        return 3;

    }


}
