import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by codecadet on 31/05/16.
 */
public class UniqueWord implements Iterable<String> {

    private Set<String> set = new HashSet<>();


    public UniqueWord(String word) {

        for (String cenas : word.split(" ")) {
            set.add(cenas);
        }
        /*
        String[] cenas = word.split(" ");
        for (int i = 0; i < cenas.length; i++) {
            set.add(cenas[i]);
        }*/
    }


    @Override
    public Iterator iterator() {
        return set.iterator();
    }
}
