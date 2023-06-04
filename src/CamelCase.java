import java.util.Arrays;
import java.util.stream.Collectors;

public class CamelCase {
    public static String camelCase(String str) {
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            String buf = "";
            if (words[i].length() > 0) {
               buf += words[i].charAt(0);
            }

            words[i] = words[i].replaceFirst(buf, buf.toUpperCase());
        }

        return Arrays.stream(words).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        System.out.println(camelCase(" hello world"));
    }
}
