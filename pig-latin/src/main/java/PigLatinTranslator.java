import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PigLatinTranslator {

    private static final String[] CONSONANT_CLUSTERS = {"ch", "sh", "sch", "th", "thr", "qu", "rh"};
    private static final String[] VOWEL_CLUSTERS = {"xr", "yt"};
    private static final String[] VOWEL_COMBINATIONS = {"a", "e", "i", "o", "u"};

    private static final String Y_LITERAL = "y";
    private static final String SPACE_LITERAL = " ";
    private static final String QU_LITERAL = "qu";
    private static final String AY_LITERAL = "ay";

    String translate(String string) {

        string = string.toLowerCase();

        String[] words = string.split(SPACE_LITERAL);
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {

            List<String> clusters = new ArrayList<>();
            clusters.addAll(Arrays.asList(CONSONANT_CLUSTERS));
            clusters.addAll(Arrays.asList(VOWEL_CLUSTERS));

            String lettersToCheck = word.substring(0, 1);
            if (string.length() > 2) {
                for (String cluster : clusters) {
                    if (cluster.equalsIgnoreCase(word.substring(0, cluster.length()))) {
                        lettersToCheck = word.substring(0, cluster.length());
                    }
                }
            }

            String convertedWord;
            if (Arrays.asList(VOWEL_COMBINATIONS).contains(lettersToCheck) || Arrays.asList(VOWEL_CLUSTERS).contains(lettersToCheck)) {
                convertedWord = string + AY_LITERAL + SPACE_LITERAL;
            }
            else {
                if ((lettersToCheck + Y_LITERAL).equalsIgnoreCase(word.substring(0, lettersToCheck.length()) + Y_LITERAL.length()) || (string.length() == 2 && string.charAt(1) == Y_LITERAL.charAt(0))) {
                    convertedWord = word.substring(lettersToCheck.length()) + lettersToCheck + AY_LITERAL + SPACE_LITERAL;
                }
                else if ((lettersToCheck + QU_LITERAL).equalsIgnoreCase(word.substring(0, lettersToCheck.length() + QU_LITERAL.length()))) {
                    convertedWord = word.substring(lettersToCheck.length() + QU_LITERAL.length()) + lettersToCheck + QU_LITERAL + AY_LITERAL + SPACE_LITERAL;
                }
                else {
                    convertedWord = word.substring(lettersToCheck.length()) + lettersToCheck + AY_LITERAL + SPACE_LITERAL;
                }
            }
            stringBuilder.append(convertedWord);
        }

        return stringBuilder.toString().trim();
    }
}