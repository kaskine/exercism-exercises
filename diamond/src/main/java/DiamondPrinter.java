import java.util.LinkedList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {

        LinkedList<String> diamond = new LinkedList<>();
        int rowWidth = (a - 65) * 2 + 1;

        int offset = (rowWidth - 1) / 2;

        for (int i = 65; i <= a; i++) {
            if (i == 65) {
                diamond.add(getEdge(offset));
            }
            else {
                diamond.add(getRow(offset, (char) i));
            }
        }

        for (int i = a - 1; i >= 65; i--) {
            if (i == 65) {
                diamond.add(getEdge(offset));
            }
            else {
                diamond.add(getRow(offset, (char) i));
            }
        }

        return diamond;
    }

    private String getEdge(int offset) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < offset; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append('A');
        for (int i = 0; i < offset; i++) {
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    private String getRow(int offset, char charToPrint) {

        StringBuilder stringBuilder = new StringBuilder();
        int edgeOffset = offset - (charToPrint - 65);
        int centerGap = (charToPrint - 1 - 65) * 2 + 1;

        for (int i = 0; i < edgeOffset; i++) {
            stringBuilder.append(' ');
        }

        stringBuilder.append(charToPrint);
        for (int i = 0; i < centerGap; i++) {
            stringBuilder.append(' ');
        }

        stringBuilder.append(charToPrint);
        for (int i = 0; i < edgeOffset; i++) {
            stringBuilder.append(' ');
        }

        return stringBuilder.toString();
    }

}
