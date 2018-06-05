class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        stringToVerify = stringToVerify.replace("-", "");

        if(stringToVerify.length() != 10) {
            return false;
        }

        int sum = 0;

        for (int i = 0; i < stringToVerify.length(); i++) {
            int val;

            if(i < stringToVerify.length() - 2 && !Character.isDigit(stringToVerify.charAt(i))) {
                return false;
            }
            if(i == stringToVerify.length() - 1) {
                char c = stringToVerify.charAt(i);

                if (c == 'X') {
                    val = 10;
                }
                else if (Character.isDigit(c)) {
                    val = Character.digit(c, 10);
                }
                else {
                    return false;
                }
            }
            else {
                val = Character.digit(stringToVerify.charAt(i), 10);
            }

            sum += val * (10 - i);
        }

        return sum % 11 == 0;
    }

}
