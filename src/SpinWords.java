import java.sql.SQLOutput;

public class SpinWords {
    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words) {
            if (word.length() >= 5) {
                String[] chars = word.split("");
                word = "";
                for (int i = chars.length - 1; i >= 0; i--) {
                    word += chars[i];
                }
            }

            result = result.concat(word).concat(" ");
        }

        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(spinWords("Hey fellow warriors"));
    }
}
