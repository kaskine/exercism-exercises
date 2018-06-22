class Acronym {

    private String acronym;

    /**
     * Constructs a new Acronym
     * @param phrase - The phrase to convert to an acronym
     */
    Acronym(String phrase) {

        phrase = phrase.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(phrase.charAt(0));

        for (int i = 1; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ' ' || phrase.charAt(i) == '-') {
                stringBuilder.append(phrase.charAt(i + 1));
            }
        }

        acronym = stringBuilder.toString();
    }

    /**
     * Getter method for the acronym
     * @return Returns a String containing the acronym
     */
    String get() {
        return acronym;
    }

}
