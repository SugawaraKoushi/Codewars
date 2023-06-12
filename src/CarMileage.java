import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarMileage {
    public static final Pattern ZEROS = Pattern.compile("\\b\\d0+\\b");
    public static final Pattern SAME_NUMBER = Pattern.compile("\\b(1+|2+|3+|4+|5+|6+|7+|8+|9+)\\b");

    public static int isInteresting(int number, int[] awesomePhrases) {
        if (number < 99 || number > 1_000_000_000) {
            return 0;
        }

        if (Arrays.stream(awesomePhrases).anyMatch(n -> n == number)) {
            return 2;
        } else if (Arrays.stream(awesomePhrases).anyMatch(n -> (Math.abs(n - number) <= 2))) {
            return 1;
        } else {
            String num = Integer.toString(number);
            Matcher zerosMatcher = ZEROS.matcher(num);
            Matcher sameNumberMatcher = SAME_NUMBER.matcher(num);

            if (zerosMatcher.find() || sameNumberMatcher.find()) {
                return 2;
            }

            String[] digits = num.split("");
            boolean isSeq = true;
            for (int i = 1; i < digits.length; i++) {
                int d1 = Integer.parseInt(digits[i - 1]);
                int d2 = Integer.parseInt(digits[i]);

                if (Math.abs(d1 - d2) != 1) {
                    isSeq = false;
                    break;
                }
            }

            if (isSeq) {
                return 2;
            } else {
                boolean isPalindrome = true;
                for (int i = 0; i < digits.length / 2; i++) {
                    if (!digits[i].equals(digits[digits.length - 1 - i])) {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome) {
                    return 2;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isInteresting(11208, new int[]{1337, 256}));
    }
}