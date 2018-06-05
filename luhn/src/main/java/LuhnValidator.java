class LuhnValidator {

    boolean isValid(String candidate) {

        StringBuilder stringBuilder = new StringBuilder();
        candidate = candidate.replace(" ", "");

        if (candidate.length() == 1) {
            return false;
        }

        for (int i = 0; i < candidate.length(); i++) {
            if (!Character.isDigit(candidate.charAt(i))) {
                return false;
            }
        }

        boolean shouldSkip = true;
        for (int i = candidate.length() - 1; i >= 0; i--) {
            int val = Character.digit(candidate.charAt(i), 10);
            if(!shouldSkip) {
                val *= 2;
                if (val > 9) {
                    val -= 9;
                }
            }
            stringBuilder.append(val);
            shouldSkip = !shouldSkip;
        }
        stringBuilder.reverse();

        int sum = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            sum += Character.digit(stringBuilder.charAt(i), 10);
        }

        return sum % 10 == 0;
    }

}
