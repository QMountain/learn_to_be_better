package algorithm.leetcode.medium.n;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int currIndex;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                list.addAll(new NestedIterator(nestedInteger.getList()).list);
            }
        }
        currIndex = 0;
    }

    @Override
    public Integer next() {
        return list.get(currIndex++);
    }

    @Override
    public boolean hasNext() {
        return currIndex < list.size();
    }

    interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }
}

