package geometry;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {
    private List<T> elements;

    public LinkedList() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public void remove(T element) {
        elements.remove(element);
    }

    public T find(int index) {
        return elements.get(index);
    }

    public int size() {
        return elements.size();
    }
}
