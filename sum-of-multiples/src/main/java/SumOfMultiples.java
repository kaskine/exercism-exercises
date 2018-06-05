class SumOfMultiples {

    private int sum;

    SumOfMultiples(int number, int[] set) {

        sum = 0;

        for (int i = 0; i < number; i++) {
            boolean isAdded = false;

            for (int val: set) {
                if (i % val == 0 && !isAdded) {
                    sum += i;
                    isAdded = true;
                }
            }
        }
    }

    int getSum() {
        return sum;
    }

}
