import java.util.HashSet;
import java.util.Random;

public class Robot {

    private static final HashSet<String> names = new HashSet<>();

    private String name;

    Robot() {
        reset();
    }

    String getName() {
        return name;
    }

    void reset() {
        String nameToCheck = createName();
        while (names.contains(nameToCheck)) {
            nameToCheck = createName();
        }
        name = nameToCheck;
        names.add(name);
    }

    private String createName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getLetter());
        stringBuilder.append(getLetter());
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(getDigit());
        }
        return stringBuilder.toString();
    }

    private char getLetter() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 65);
    }

    private int getDigit() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
