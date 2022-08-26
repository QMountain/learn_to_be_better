package algorithm.leetcode.medium.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    List<Integer> list;
    int index;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        index = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(index);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    public static void main(String[] args) {

    }
}
