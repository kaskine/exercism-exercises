class NaturalNumber {

    private Classification classification;

    NaturalNumber(int number) {

        if(number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        if (sum == number) {
            classification = Classification.PERFECT;
        }
        else if (sum > number) {
            classification = Classification.ABUNDANT;
        }
        else {
            classification = Classification.DEFICIENT;
        }

    }

    Classification getClassification() {
        return classification;
    }
}
