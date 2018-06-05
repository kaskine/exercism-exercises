import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Matrix {

    private List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {

        LinkedList<MatrixCoordinate> potentials = new LinkedList<>();
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();

        for (int rowNumber = 0; rowNumber < values.size(); rowNumber++) {
            List<Integer> row = values.get(rowNumber);
            int largestValue = row.get(0);

            for (Integer currentValue : row) {
                if (currentValue > largestValue) {
                    largestValue = currentValue;
                }
            }

            for (int positionInCurrentRow = 0; positionInCurrentRow < row.size(); positionInCurrentRow++) {
                if (row.get(positionInCurrentRow) == largestValue) {
                    potentials.add(new MatrixCoordinate(rowNumber, positionInCurrentRow));
                }
            }
        }

        for (MatrixCoordinate coordinate: potentials) {
            int columnCoordinate = coordinate.getCol();
            boolean isSmallest = true;
            int myValue = values.get(coordinate.getRow()).get(coordinate.getCol());

            for (List<Integer> value : values) {
                int valToCompare = value.get(columnCoordinate);

                if (myValue > valToCompare) {
                    isSmallest = false;
                    break;
                }
            }

            if (isSmallest) {
                saddlePoints.add(coordinate);
            }
        }


        return saddlePoints;
    }
}
