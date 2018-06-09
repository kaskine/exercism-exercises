public class Bob {

    private static final String CHILL = "Whoa, chill out!";
    private static final String SURE = "Sure.";
    private static final String FINE = "Fine. Be that way!";
    private static final String CALM = "Calm down, I know what I'm doing!";
    private static final String WHATEVER = "Whatever.";

    private static final String REGEX_EXCLAMATION = "(.+[!])|([A-Z\\s\\W]+[!]?)";
    private static final String REGEX_QUESTION = "[a-zA-Z\\s]+[?]";

    String hey(String s) {

        s = s.trim();
        if (s.contains("?") && s.equals(s.toUpperCase()) && s.matches(REGEX_QUESTION)) {
            return CALM;
        }
        if (s.lastIndexOf('?') == s.length() - 1 && s.length() != 0) {
            return SURE;
        }
        if (s.matches("[^/w]") || s.isEmpty()) {
            return FINE;
        }
        if (s.equals(s.toUpperCase()) && s.matches(REGEX_EXCLAMATION)) {
            return CHILL;
        }

        return WHATEVER;
    }
}
