import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class PrimeFactorsCalculator {

    List<Long> calculatePrimeFactorsOf(long n) {

        List<Long> factors = new LinkedList<>();
        for (long i = 2; i <= n; i++) {
            if (n % i == 0) {
                n /= i;
                ((LinkedList<Long>) factors).push(i);
                i = 1;
            }
        }
        Collections.sort(factors);
        return factors;
    }
}
