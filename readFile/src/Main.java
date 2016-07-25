import java.io.IOException;
import java.util.Iterator;

/**
 * Created by codecadet on 01/06/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        WordReader cenas = new WordReader("/Users/codecadet/Downloads/test.txt");

        Iterator<String> iterator = cenas.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
