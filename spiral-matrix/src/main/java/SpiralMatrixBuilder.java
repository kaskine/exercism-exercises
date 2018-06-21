class SpiralMatrixBuilder {

    /**
     * Builds a spiral matrix of the given size
     * @param size - The value which determines the size of the 2 - Dimensional matrix. I.E. a size of 3 will create a 3 - by - 3 matrix
     * @return Returns a spiral matrix with the given proportions
     */
    int[][] buildMatrixOfSize(int size) {

        int[][] matrix = new int[size][size];

        int horizontalIndex = 0;
        int verticalIndex = 0;
        Direction direction = Direction.RIGHT;

        for (int i = 1; i <= size * size; i++) {
            matrix[verticalIndex][horizontalIndex] = i;
            if (direction.isHorizontal()) {
                if (isBoundary(horizontalIndex, direction, size)) {
                    direction = direction.getRotatedValue();
                    verticalIndex += direction.getModifier();
                }
                else if (matrix[verticalIndex][horizontalIndex + direction.getModifier()] != 0) {
                    direction = direction.getRotatedValue();
                    verticalIndex += direction.getModifier();
                }
                else {
                    horizontalIndex += direction.getModifier();
                }
            }
            else {
                if (isBoundary(verticalIndex, direction, size)) {
                    direction = direction.getRotatedValue();
                    horizontalIndex += direction.getModifier();
                }
                else if (matrix[verticalIndex + direction.getModifier()][horizontalIndex] != 0) {
                    direction = direction.getRotatedValue();
                    horizontalIndex += direction.getModifier();
                }
                else {
                    verticalIndex += direction.getModifier();
                }
            }
        }
        return matrix;
    }

    /**
     * Determines if the index cannot move further in the current direction.
     * @param index - The current index along the axis of traversal
     * @param direction - The direction the index is moving in
     * @param size - The size property of the matrix
     * @return Returns true if the index will throw an ArrayIndexOutOfBoundsException if any value beyond this accessed in the given direction.
     */
    private boolean isBoundary(int index, Direction direction, int size) {
        return index + direction.getModifier() == size || index + direction.getModifier() < 0;
    }
}

enum Direction {
    UP(-1), RIGHT(1), DOWN(1), LEFT(-1);

    private int modifier;

    /**
     * Constructs a Direction enum
     * @param modifier - The modifier to be used when iterating over an array in the chosen direction.
     */
    Direction(int modifier) {
        this.modifier = modifier;
    }

    /**
     * Accessor method for the modifier property
     * @return Returns an int which is the modifier to be used when iterating over an array using the current Direction
     */
    int getModifier() {
        return modifier;
    }

    /**
     * Returns a value representing whether or not the Direction upon which this method is called is horizontal.
     * @return Returns true if the Direction enum which invokes this method is horizontal.
     */
    boolean isHorizontal() {
        return this == RIGHT || this == LEFT;
    }

    /**
     * Utility method to return the next rotation in the cycle. Rotates clockwise.
     * @return Returns the clockwise-rotated direction from the Direction enum upon which this method is invoked.
     */
    Direction getRotatedValue() {
        switch (this) {
            case UP:
                return RIGHT;
            case RIGHT:
                return DOWN;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            default:
                return RIGHT;
        }

    }
}
