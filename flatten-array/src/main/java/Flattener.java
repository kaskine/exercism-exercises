import java.util.LinkedList;
import java.util.List;

public class Flattener {

    public <T> List<T> flatten(List<List> lists) {
        LinkedList<T> linkedList = new LinkedList<>();

        for (List<List> list: lists) {
            list.addAll(linkedList);
        }

        return linkedList;
    }
}
