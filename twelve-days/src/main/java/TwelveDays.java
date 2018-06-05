class TwelveDays {

    private final String GIFT1 = "a Partridge in a Pear Tree";
    private final String GIFT2 = "two Turtle Doves";
    private final String GIFT3 = "three French Hens";
    private final String GIFT4 = "four Calling Birds";
    private final String GIFT5 = "five Gold Rings";
    private final String GIFT6 = "six Geese-a-Laying";
    private final String GIFT7 = "seven Swans-a-Swimming";
    private final String GIFT8 = "eight Maids-a-Milking";
    private final String GIFT9 = "nine Ladies Dancing";
    private final String GIFT10 = "ten Lords-a-Leaping";
    private final String GIFT11 = "eleven Pipers Piping";
    private final String GIFT12 = "twelve Drummers Drumming";

    String verse(int verseNumber) {
        if(verseNumber == 1) {
            return "On the " + getDayWord(verseNumber) + " day of Christmas my true love gave to me, " + getGift(verseNumber) + ".\n";
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("On the " + getDayWord(verseNumber) + " day of Christmas my true love gave to me, ");

            for (int i = verseNumber; i > 1; i--) {
                stringBuilder.append(getGift(i) + ", ");
            }
            stringBuilder.append("and " + getGift(1) + ".\n");

            return stringBuilder.toString();
        }
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = startVerse; i <= endVerse; i++) {
            stringBuilder.append(verse(i));
            if(i < endVerse) {
                stringBuilder.append("\n");
            }
        }

        return stringBuilder.toString();
    }
    
    String sing() {
        return verses(1, 12);
    }

    private String getDayWord(int day) {
        switch (day) {
            case 1:
                return "first";
            case 2:
                return "second";
            case 3:
                return "third";
            case 4:
                return "fourth";
            case 5:
                return "fifth";
            case 6:
                return "sixth";
            case 7:
                return "seventh";
            case 8:
                return "eighth";
            case 9:
                return "ninth";
            case 10:
                return "tenth";
            case 11:
                return "eleventh";
            case 12:
                return "twelfth";
            default:
                return "Your mother was a hamster and your father smelled of Elderberries.";
        }
    }

    private String getGift(int day) {

        switch (day) {
            case 1:
                return GIFT1;
            case 2:
                return GIFT2;
            case 3:
                return GIFT3;
            case 4:
                return GIFT4;
            case 5:
                return GIFT5;
            case 6:
                return GIFT6;
            case 7:
                return GIFT7;
            case 8:
                return GIFT8;
            case 9:
                return GIFT9;
            case 10:
                return GIFT10;
            case 11:
                return GIFT11;
            case 12:
                return GIFT12;
            default:
                return "There are only twelve days of Christmas, don't ask for more.";
        }
    }
}
