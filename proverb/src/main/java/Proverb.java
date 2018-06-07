class Proverb {

    private String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {

        if (words.length == 0) {
            return "";
        }

        if (words.length == 1) {
            return "And all for the want of a " + words[0] + ".";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < words.length - 1; i++) {
            String string = "For want of a " + words[i] + " the " + words[i + 1] + " was lost." + "\n";
            stringBuilder.append(string);
        }
        String string = "And all for the want of a " + words[0] + ".";
        stringBuilder.append(string);

        return stringBuilder.toString();
    }

}
