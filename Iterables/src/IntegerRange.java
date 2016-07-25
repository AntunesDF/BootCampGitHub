import java.util.Iterator;

/**
 * Created by codecadet on 30/05/16.
 */
public class IntegerRange implements Iterable {

    private int min;
    private int max;

    public IntegerRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {

            private int i = min - 1;

            @Override
            public Object next() {
                return i;
            }

            @Override
            public boolean hasNext() {
                if (i++ < max) {
                    return true;
                }
                return false;
            }

            @Override
            public void remove() {

            }
        };
    }
}
