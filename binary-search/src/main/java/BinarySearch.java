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
     * Searches the list for the item T given as an argument in log n time
     * @param item - The item to search for in the collection
     * @return Returns the index of the item given as an argument
     */
    int indexOf(T item) {

        if (!itemList.isEmpty()) {

            if (itemList.size() == 1) {
                return 0;
            }

            int lowerBound = 0;
            int upperBound = itemList.size() - 1;
            int index = (int) Math.ceil(itemList.size() / 2);

            while (!isNotInArray(item, index, lowerBound, upperBound)) {
                int compareResult = item.compareTo(itemList.get(index));

                if (compareResult == 0) {
                    return index;
                }
                else if (compareResult > 0) {
                    lowerBound = index;
                    index = (int)(Math.ceil(((double)index + upperBound) / 2));
                }
                else {
                    upperBound = index;
                    index = (int)(Math.floor(((double)index - lowerBound) / 2));
                }
            }
        }
        return -1;
    }

    /**
     * Evaluates cases in which the item does not exist in the collection
     * @param item - The item to find
     * @param index - The current index
     * @param lowerBound - The lower bound of the search space
     * @param upperBound - The upper bound of the search space
     * @return Returns true if the item cannot be found in the collection
     */
    private boolean isNotInArray(T item, int index, int lowerBound, int upperBound) {
        return (lowerBound == upperBound) || ((index == upperBound || index == lowerBound) && item != itemList.get(index));
    }
}
