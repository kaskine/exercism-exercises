class RotationalCipher {

    private final int upperCaseBase = 65;
    private final int lowerCaseBase = 97;
    private final int range = 26;

    private int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            int base;

            if(Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    base = upperCaseBase;
                }
                else {
                    base = lowerCaseBase;
                }

                int offset = c - base;
                offset += shiftKey;

                if(base + offset >= base + range) {
                    offset -= range;
                }

                c = (char)(base + offset);
            }

            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

}
