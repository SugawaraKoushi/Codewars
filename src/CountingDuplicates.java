import java.util.HashSet;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        HashSet<Character> chars = new HashSet<>();
        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            if (text.lastIndexOf(text.charAt(i)) != i)
                chars.add(text.charAt(i));
        }

        return chars.size();
    }

    public static void main(String[] args) {

    }
}