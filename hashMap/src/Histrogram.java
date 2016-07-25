import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by codecadet on 31/05/16.
 */
public class Histrogram implements Iterable<String>{

    private Map<String, Integer> histo = new HashMap<>();


    public Histrogram(String words) {

        for (String word : words.split(" ")) {

            if (histo.containsKey(word)){
                histo.put(word, histo.get(word) + 1);
            }
            else {
                histo.put(word, 1);
            }
        }
    }


    public Integer getWordCount(String word) {
        return histo.get(word);
    }


    @Override
    public Iterator<String> iterator() {
        return histo.keySet().iterator();
    }
}
