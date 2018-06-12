import java.util.ArrayList;
import java.util.List;

public class Series {

    private List<Integer> digits;

    Series(String values) {

        String[] split = values.split("");
        this.digits = new ArrayList<>();

        for (String s: split) {
            this.digits.add(Integer.parseInt(s));
        }
    }

    List<Integer> getDigits() {
        return digits;
    }

    List<List<Integer>> slices(int spacing) {

        if (spacing > digits.size()) {
            throw new IllegalArgumentException();
        }

        List<List<Integer>> series = new ArrayList<>();
        for (int i = 0; i < digits.size(); i++) {

            if (i + spacing <= digits.size()) {
                List<Integer> next = new ArrayList<>();
                for (int j = i; j < i + spacing; j++) {
                    next.add(digits.get(j));
                }
                series.add(next);
            }
        }
        return series;
    }
}
