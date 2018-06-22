import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class RomanNumeral {

    private final List<Character> numeralsList = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');
    private final List<Character> detractorList = Arrays.asList('I', 'X', 'C');

    private HashMap<Character, Integer> numeralsMap;
    private String numeral;

    private RomanNumeral() {}

    /**
     * Constructs a Roman Numeral Object from the value given as an argument
     * @param valueToConvert - The int that will be converted into a Roman Numeral
     */
    RomanNumeral(int valueToConvert) {

        numeralsMap = new HashMap<>();
        numeralsMap.put('I', 1);
        numeralsMap.put('V', 5);
        numeralsMap.put('X', 10);
        numeralsMap.put('L', 50);
        numeralsMap.put('C', 100);
        numeralsMap.put('D', 500);
        numeralsMap.put('M', 1000);

        StringBuilder stringBuilder = new StringBuilder();

        while (valueToConvert > 0) {

            if (valueToConvert >= 1000) {
                char c = numeralsList.get(numeralsList.size() - 1);
                stringBuilder.append(c);
                valueToConvert -= numeralsMap.get(c);
            }
            else {

                for (int i = numeralsList.size() - 1; i >= 0; i--) {

                    char c = numeralsList.get(i);
                    int numeralValue = numeralsMap.get(c);

                    if (numeralValue <= valueToConvert) {
                        c = numeralsList.get(i);

                        if (isReverseCombinationSet(i, valueToConvert)) {
                            stringBuilder.append(c);
                            stringBuilder.append(numeralsList.get(i + 1));

                            valueToConvert -= (numeralsMap.get(numeralsList.get(i + 1)) - numeralsMap.get(c));
                        }
                        else if (isIgnoredSet(i, valueToConvert)) {
                            stringBuilder.append(numeralsList.get(i - 1));
                            stringBuilder.append(numeralsList.get(i + 1));

                            valueToConvert -= (numeralsMap.get(numeralsList.get(i + 1)) - numeralsMap.get(
                                    numeralsList.get(i - 1)));
                        }
                        else {
                            stringBuilder.append(c);
                            valueToConvert -= numeralsMap.get(c);
                        }
                        break;
                    }
                }
            }
        }
        numeral = stringBuilder.toString();
    }

    /**
     * A getter method for the converted value.
     * @return Returns a String containing the Roman Numeral equivalent of the int given when the constructor was called
     */
    String getRomanNumeral() {
        return numeral;
    }

    /**
     * Determines whether the current value should be represented by a combination set instead of
     * a single character. An example of this is the number 4 being represented as "IV" instead of "IIII"
     * @param position - The current position of the character being checked in the loop
     * @param valueToConvert - The current value of the integer being converted to a Roman Numeral
     * @return Returns true if the value should be represented by a combination set
     */
    private boolean isReverseCombinationSet(int position, int valueToConvert) {
        return (position < numeralsList.size() - 1
                && detractorList.contains(numeralsList.get(position))
                && valueToConvert >= numeralsMap.get(numeralsList.get(position + 1)) - numeralsMap.get(numeralsList.get(position)));

    }

    /**
     * Determines whether the current value should be represented by a set which excludes the value at the current position
     * in the loop through the character values. An example of this is the number 9 being represented as "IX" despite 'V'
     * (having a value of 5) being the closest value.
     * @param position - The current position of the character being checked in the loop
     * @param valueToConvert - The current value of the integer being converted to a Roman Numeral
     * @return Returns true if the value should be represented by a set which ignores the character at the current position.
     */
    private boolean isIgnoredSet(int position, int valueToConvert) {
        return (position < numeralsList.size() - 1
                && position > 0
                && detractorList.contains(numeralsList.get(position - 1))
                && valueToConvert >= numeralsMap.get(numeralsList.get(position + 1)) - numeralsMap.get(
                numeralsList.get(position - 1)));
    }
}
