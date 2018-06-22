import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Allergies {

    private List<Allergen> allergenList;

    /**
     * Constructs a list of allergens from an allergen score
     * @param totalAllergenScore - The total allergen score to parse into a list of known allergens
     */
    Allergies(int totalAllergenScore) {

        allergenList = new LinkedList<>();

        int i = 0;
        while (totalAllergenScore != 0) {

            int currentScore = (int) Math.pow(2, i);
            if (currentScore > totalAllergenScore) {
                int highestAllergenScore = (int) Math.pow(2, i - 1);
                totalAllergenScore -= highestAllergenScore;
                i = 0;

                for (Allergen allergen : Allergen.values()) {
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

    /**
     * Checks to see if the list contains the allergen given as an argument
     * @param allergen - The allergen to check for in the list
     * @return Returns true if the individual is allergic to the allergen given as an argument
     */
    boolean isAllergicTo(Allergen allergen) {
        return allergenList.contains(allergen);
    }

    /**
     * Getter method for the list of allergens
     * @return Returns the list of known allergies
     */
    List<Allergen> getList() {
        return allergenList;
    }
}
