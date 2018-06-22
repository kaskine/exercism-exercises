import java.util.List;

class BinarySearch<T extends Comparable<T>> {

    private List<T> itemList;

    /**
     * Constructs a new BinarySearch object
     * @param list - A list of items containing the values to be searched
     */
    BinarySearch(List<T> list) {
        this.itemList = list;
    }

    /**
     * Searches the list for the item T given as an argument in O(log n) time
     * @param item - The item to search for in the collection
     * @return Returns the index of the item given as an argument
     */
    int indexOf(T item) {

        int lowerBound = 0;
        int upperBound = itemList.size() - 1;

        while (lowerBound <= upperBound) {
            int index = lowerBound + (upperBound - lowerBound) / 2;
            int compareResult = item.compareTo(itemList.get(index));

            if (compareResult == 0) {
                return index;
            }
            else if (compareResult > 0) {
                lowerBound = index + 1;
            }
            else {
                upperBound = index - 1;
            }
        }
        return -1;
    }
}
