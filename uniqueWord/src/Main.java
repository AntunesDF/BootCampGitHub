/**
 * Created by codecadet on 31/05/16.
 */
public class Main {

    public static void main(String[] args) {

        UniqueWord uw = new UniqueWord("Cenas maisCenas Cenas cenasAgain Cenas");

        for (String word : uw) {
            System.out.println(word);
        }

    }
}
