import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by codecadet on 01/06/16.
 */
public class WordReader implements Iterable<String>{

    private String[] results;


    public WordReader(String file) throws IOException {
        readFile(file);
    }


    private void readFile(String file) throws IOException {

        FileReader reader = new FileReader(file);

        BufferedReader bReader = new BufferedReader(reader);

        String line;
        String result = "";

        while((line = bReader.readLine()) != null) {
            result += line + "\n";
        }

        bReader.close();

        results = result.split("\\W+");

    }


    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {

            private int index;

            @Override
            public boolean hasNext() {
                if (index == results.length) {
                    return false;
                }
                return true;
            }

            @Override
            public String next() {

                if (hasNext() == false) {
                    throw new NoSuchElementException();
                }
                return results[index++];
            }

            @Override
            public void remove() {

            }
        };
    }
}
