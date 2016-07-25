/**
 * Created by codecadet on 12/07/16.
 */
public class EnglishNumber {

    private static final String[] ones = {
            " one", " two", " three", " four", " five",
            " six", " seven", " eight", " nine", " ten",
            " eleven", " twelve", " thirteen", " fourteen",
            " fifteen", " sixteen", " seventeen",
            " eighteen", " nineteen"
    };
    private static final String[] tens = {
            " twenty", " thirty", " forty", " fifty",
            " sixty", " seventy", " eighty", " ninety"
    };
    // so quintillions is as big as it gets. The
    // program would automatically handle larger
    // numbers if this array were extended.
    private static final String[] groups = {
            "",
            " thousand",
            " million",
            " billion",
            " trillion",
            " quadrillion",
            " quintillion"
    };

    private String string = new String();

    public String getString() {
        return string;
    }

    public EnglishNumber(long n) {

        // Go through the number one group at a time.
        for (int i = groups.length - 1; i >= 0; i--) {

            // Is the number as big as this group?
            long cutoff = (long) Math.pow((double) 10, (double) (i * 3));

            if (n >= cutoff) {

                int thisPart = (int) (n / cutoff);

                // Use the ones[] array for both the hundreds and the ones digit.
                // Note that tens[] starts at "twenty".
                if (thisPart >= 100) {
                    string += ones[(thisPart / 100) - 1] + " hundred";
                    thisPart = thisPart % 100;
                }
                if (thisPart >= 20) {
                    string += tens[(thisPart / 10) - 2];
                    thisPart = thisPart % 10;
                }
                if (thisPart >= 1) {
                    string += ones[thisPart - 1];
                }

                string += groups[i];
                n = n % cutoff;
            }
        }

        if (string.length() == 0) {
            string = "zero";
        } else {
            // remove initial space
            string = string.substring(1);
        }
    }
}
