import java.util.ArrayList;
import java.util.List;

class Sieve {

    private int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {

        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        for (int base = 2; base <= maxPrime; base++) {
            if (!values.contains(base)) {
                primes.add(base);

                int valueToMultiplyBy = 1;
                int currentMultiple = valueToMultiplyBy * base;

                while (currentMultiple <= maxPrime) {
                    values.add(currentMultiple);
                    currentMultiple = base * valueToMultiplyBy++;
                }

            }
        }
        return primes;
    }
}
