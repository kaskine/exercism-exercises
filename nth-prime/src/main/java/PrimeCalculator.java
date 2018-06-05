class PrimeCalculator {

    int nth(int nth) {

        if (nth <= 0) {
            throw new IllegalArgumentException();
        }
        int primesFound = 0;
        int value = 1;
        while (primesFound < nth) {
            value++;
            boolean isPrime = true;
            for (int i = 2; i <= value / 2; i++) {
                if(value % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primesFound++;
            }
        }

        return value;
    }


}
