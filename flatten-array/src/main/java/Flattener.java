import java.util.LinkedList;
import java.util.List;

class Flattener {

    List<Object> flatten(List<Object> objectList) {

        LinkedList<Object> returnList = new LinkedList<>();
        LinkedList<Object> stack = new LinkedList<>(objectList);

        while (!stack.isEmpty()) {
            Object obj = stack.pop();
            if (obj instanceof List<?>) {
                stack.addAll(0, (List<?>) obj);
            }
            else if (obj != null) {
                returnList.add(obj);
            }
        }

        return returnList;
    }
}
