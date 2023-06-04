import java.util.HashMap;

public class DuplicateEncoder {
    static String encode(String word) {
        word = word.toLowerCase();
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            if (freq.containsKey(word.charAt(i))) {
                freq.put(word.charAt(i), freq.get(word.charAt(i)) + 1);
            } else {
                freq.put(word.charAt(i), 1);
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (freq.get(word.charAt(i)) > 1) {
                result.append(")");
            } else {
                result.append("(");
            }
        }

        return result.toString();
    }

//    public class DuplicateEncoder {
//        static String encode(String word){
//            word = word.toLowerCase();
//            String result = "";
//            for (int i = 0; i < word.length(); ++i) {
//                char c = word.charAt(i);
//                result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
//            }
//            return result;
//        }
//    }

    public static void main(String[] args) {
        System.out.println(encode("Prespecialized"));
    }
}