import java.util.ArrayList;

class Matrix {

    private ArrayList<int[]> matrix;

    Matrix(String matrixAsString) {

        matrix = new ArrayList<>();
        String[] rows = matrixAsString.split("\n");

        for (String row: rows) {
            String delims = "[ ]+";
            String[] tokens = row.split(delims);
            int[] ints = new int[tokens.length];

            for (int i = 0; i < tokens.length; i++) {
                ints[i] = Integer.parseInt(tokens[i]);
            }

            matrix.add(ints);
        }
    }

    int[] getRow(int rowNumber) {
        return matrix.get(rowNumber);
    }

    int[] getColumn(int columnNumber) {

        ArrayList<Integer> column = new ArrayList<>();
        for (int[] row : matrix) {
            column.add(row[columnNumber]);
        }

        int[] ints = new int[column.size()];
        for (int i = 0; i < column.size(); i++) {
            ints[i] = column.get(i);
        }

        return ints;
    }

    int getRowsCount() {
        return matrix.size();
    }

    int getColumnsCount() {
        return matrix.get(1).length;
    }
}
