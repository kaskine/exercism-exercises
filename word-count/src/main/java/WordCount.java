import java.util.HashMap;
import java.util.Map;

class WordCount {

    Map<String, Integer> map;

    Map<String, Integer> phrase(String string) {

        map = new HashMap<>();

        string = string.replaceAll("[^ 'a-zA-Z0-9]", " ");
        string = string.trim();
        String[] words = string.toLowerCase().split("[ ]+");

        for (String word: words) {
            if (word.charAt(0) == '\'' && word.charAt(0) == '\'') {
                word = word.substring(1, word.length() - 1);
            }
            if (map.containsKey(word)) {
                map.replace(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }

        return map;
    }
}
