/**
 * Created by codecadet on 31/05/16.
 */
public class Main {

    public static void main(String[] args) {

        Histrogram histo = new Histrogram("Antunes Pavel Antunes Claro Antunes Engenheiro");

        for (String word : histo) {
            int number = histo.getWordCount(word);
            System.out.println(word + ": " + number);
        }
    }
}
