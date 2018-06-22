public class Atbash {

    private final int BASE = 97;
    private final int MAX = 122;

    /**
     * Encodes a String using the Atbash Cipher
     * @param string - The String to encode
     * @return Returns the encoded String
     */
    String encode(String string) {

        string = string.toLowerCase();
        StringBuilder result = new StringBuilder();

        int location = 0;
        int i = 0;
        while (location < string.length()) {
            if (i == 5 && location + 1 != string.length()) {
                result.append(" ");
                i = 0;
            }
            else {
                if (Character.isAlphabetic(string.charAt(location))) {
                    int difference = MAX - string.charAt(location++);
                    char replacement = (char) (BASE + difference);
                    result.append(replacement);
                    i++;
                }
                else if (Character.isDigit(string.charAt(location))) {
                    result.append(string.charAt(location++));
                    i++;
                }
                else {
                    location++;
                }
            }
        }
        return result.toString();
    }

    /**
     * Decodes a String that has been encoded using the Atbash Cipher
     * @param string - The String to decode
     * @return Returns the decoded String
     */
    String decode(String string) {

        string = string.toLowerCase();
        StringBuilder result = new StringBuilder();

        int location = 0;
        while (location < string.length()) {
            if (Character.isAlphabetic(string.charAt(location))) {
                int difference = MAX - string.charAt(location++);
                char replacement = (char) (BASE + difference);
                result.append(replacement);
            }
            else if (Character.isDigit(string.charAt(location))) {
                result.append(string.charAt(location++));
            }
            else {
                location++;
            }

        }
        return result.toString();
    }
}
