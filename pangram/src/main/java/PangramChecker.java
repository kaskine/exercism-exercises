public class PangramChecker {

    public boolean isPangram(String input) {

        input = input.toLowerCase();

        for (int i = 97; i < 123; i++) {
            if(!input.contains(Character.toString((char)i)))
                return false;
        }

        return true;
    }

}
