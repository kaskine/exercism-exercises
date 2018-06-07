class LargestSeriesProductCalculator {

    private String input;

    LargestSeriesProductCalculator(String inputNumber) {

        for (int i = 0; i < inputNumber.length(); i++) {
            if(!Character.isDigit(inputNumber.charAt(i))) {
                throw new IllegalArgumentException("String to search may only contain digits.");
            }
        }

        input = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {

        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        else if (numberOfDigits == 0) {
            return 1;
        }
        else if (numberOfDigits > input.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        int largest = 0;
        for (int i = 0; i < input.length() - numberOfDigits + 1; i++) {
            String currentSubsection = input.substring(i, i + numberOfDigits);
            int product = Character.digit(currentSubsection.charAt(0), 10);

            for (int j = 1; j < currentSubsection.length(); j++) {
                product *= Character.digit(currentSubsection.charAt(j), 10);
            }

            if(product > largest) {
                largest = product;
            }

        }

        return largest;
    }
}
