public class Bob {

    private static final String CHILL = "Whoa, chill out!";
    private static final String SURE = "Sure.";
    private static final String FINE = "Fine. Be that way!";
    private static final String CALM = "Calm down, I know what I'm doing!";
    private static final String WHATEVER = "Whatever.";

    private static final String REGEX_EXCLAMATION = "(.+[!])|([A-Z\\s\\W]+[!]?)";
    private static final String REGEX_QUESTION = "[a-zA-Z\\s]+[?]";

    /**
     * Determines Bob's response to a given statement
     * @param statement - The statement Bob will respond to
     * @return Returns Bob's response
     */
    String hey(String statement) {

        statement = statement.trim();
        if (statement.contains("?") && statement.equals(statement.toUpperCase()) && statement.matches(REGEX_QUESTION)) {
            return CALM;
        }
        if (statement.lastIndexOf('?') == statement.length() - 1 && statement.length() != 0) {
            return SURE;
        }
        if (statement.matches("[^/w]") || statement.isEmpty()) {
            return FINE;
        }
        if (statement.equals(statement.toUpperCase()) && statement.matches(REGEX_EXCLAMATION)) {
            return CHILL;
        }

        return WHATEVER;
    }
}
