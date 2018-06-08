class RunLengthEncoding {

    String encode(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        if (!s.isEmpty()) {

            char lastChar = s.charAt(0);
            int occurrences = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == lastChar) {
                    occurrences++;
                }
                else {
                    addOccurrence(stringBuilder, occurrences, lastChar);
                    lastChar = s.charAt(i);
                    occurrences = 1;
                }
            }
            addOccurrence(stringBuilder, occurrences, lastChar);
        }

        return stringBuilder.toString();
    }

    String decode(String s) {

        StringBuilder output = new StringBuilder();

        if (!s.isEmpty()) {

            for (int i = 0; i < s.length(); i++) {

                if (Character.isDigit(s.charAt(i))) {
                    StringBuilder digits = new StringBuilder();
                    digits.append(s.charAt(i));

                    char nextChar = s.charAt(i + 1);
                    while (Character.isDigit(nextChar)) {
                        i += 1;
                        digits.append(s.charAt(i));
                        nextChar = s.charAt(i + 1);
                    }
                    int digit = Integer.parseInt(digits.toString());

                    for (int j = 0; j < digit; j++) {
                        output.append(nextChar);
                    }
                    i += 1;
                }
                else {
                    output.append(s.charAt(i));
                }
            }
        }

        return output.toString();
    }

    private void addOccurrence(StringBuilder stringBuilder, int occurrences, char c) {
        if (occurrences > 1) {
            stringBuilder.append(occurrences);
        }
        stringBuilder.append(c);
    }
}
