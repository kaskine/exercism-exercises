import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        phrase = phrase.toLowerCase();
        phrase = phrase.replace("-", "");
        phrase = phrase.replace(" ", "");

        Set<Character> letters = new HashSet<>();
        for (int i = 0; i < phrase.length(); i++) {
            if (letters.contains(phrase.charAt(i))) {
                return false;
            }
            letters.add(phrase.charAt(i));
        }
        return true;
    }

}
