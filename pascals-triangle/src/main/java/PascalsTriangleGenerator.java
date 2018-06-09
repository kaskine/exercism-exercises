import java.util.ArrayList;
import java.util.List;

class PascalsTriangleGenerator {

    Object[] generateTriangle(int rowsToGenerate) {

        if (rowsToGenerate < 0) {
            throw new IllegalArgumentException();
        }

        List<int[]> rows = new ArrayList<>();

        for (int i = 0; i < rowsToGenerate; i++) {
            int[] currentRow = new int[i + 1];

            for (int j = 0; j < currentRow.length; j++) {
                if (j == 0) {
                    currentRow[j] = 1;
                }
                else {
                    int[] previousRow = rows.get(i - 1);
                    if (j == previousRow.length) {
                        currentRow[j] = previousRow[j - 1];
                    }
                    else {
                        currentRow[j] = previousRow[j - 1] + previousRow[j];
                    }
                }
            }
            rows.add(currentRow);
        }
        return rows.toArray();
    }
}
