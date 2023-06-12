import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopWords {
    public static List<String> top3(String s) {
        String[] words = s.split("[^'\\w]");
        Map<String, Long> freq = Arrays.stream(words)
                .toList()
                .stream()
                .filter(w -> !w.isBlank() && !w.trim().matches("'+"))
                .toList()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<String, Long>> list = new ArrayList<>(freq.entrySet());

        list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()) != 0 ?
                o2.getValue().compareTo(o1.getValue()) :
                Integer.compare(o1.getKey().compareTo(o2.getKey()), 0));

        List<String> result = new ArrayList<>();
        for (int i = 0; i < (Math.min(list.size(), 3)); i++) {
             result.add(list.get(i).getKey().toLowerCase());
        }

        result.sort(Comparator.reverseOrder());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(top3("""
                  ''''  
                """));
    }
}