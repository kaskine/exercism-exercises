import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class NucleotideCounter {

    private static final Character[] NUCLEOTIDES = {'A', 'C', 'G', 'T'};

    private Map<Character, Integer> map;

    NucleotideCounter(String s) {

        map = new HashMap<>();
        for (char c: NUCLEOTIDES) {
            map.put(c, 0);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!Arrays.asList(NUCLEOTIDES).contains(c)) {
                throw new IllegalArgumentException();
            }
            map.replace(c, map.get(c) + 1);
        }
    }

    Map<Character,Integer> nucleotideCounts() {
        return map;
    }
}
