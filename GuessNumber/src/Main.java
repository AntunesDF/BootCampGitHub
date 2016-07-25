/**
 * Created by codecadet on 09/05/16.
 */
public class Main {

    public static final int NUM_PLAYERS = 3;

    public static void main(String[] args) {

        Player[] players = new Player[NUM_PLAYERS];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }

        Game game = new Game(players);
        game.start();
    }

}
