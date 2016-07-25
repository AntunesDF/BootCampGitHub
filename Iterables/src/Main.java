import java.util.Iterator;

/**
 * Created by codecadet on 30/05/16.
 */
public class Main {

    public static void main(String[] args) {

        IntegerRange ir = new IntegerRange(5, 10);


        Iterator<Integer> iter = ir.iterator();


        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
