/**
 * Created by codecadet on 12/07/16.
 */
public class Main {

    public static void main(String[] args) {

        EnglishNumber number = new EnglishNumber(0);
        System.out.println(number.getString());

        EnglishNumber number1 = new EnglishNumber(1);
        System.out.println(number1.getString());

        EnglishNumber number2 = new EnglishNumber(20);
        System.out.println(number2.getString());

        EnglishNumber number3 = new EnglishNumber(100);
        System.out.println(number3.getString());
    }
}
