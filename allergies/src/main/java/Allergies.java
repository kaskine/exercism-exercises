import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Allergies {

    private List<Allergen> allergenList;

    Allergies(int totalAllergenScore) {

        allergenList = new LinkedList<>();

        int i = 0;
        while (totalAllergenScore != 0) {

            int currentScore = (int)Math.pow(2, i);
            if (currentScore > totalAllergenScore) {
                int highestAllergenScore = (int)Math.pow(2, i - 1);
                totalAllergenScore -= highestAllergenScore;
                i = 0;

                for (Allergen allergen: Allergen.values()) {
                    if (allergen.getScore() == highestAllergenScore) {
                        allergenList.add(allergen);
                        break;
                    }
                }
            }
            i++;
        }

        Collections.reverse(allergenList);
    }

    boolean isAllergicTo(Allergen allergen) {
        return allergenList.contains(allergen);
    }

    List<Allergen> getList() {
        return allergenList;
    }
}
