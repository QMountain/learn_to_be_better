package algorithm.leetcode.medium.b;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    List<String> list;
    int index;
    int size;

    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
        index = 0;
        size = 1;
    }

    public void visit(String url) {
        if (index == list.size() - 1) {
            list.add(url);
        } else {
            list.set(index + 1, url);
        }
        ++index;
        size = index + 1;
    }

    public String back(int steps) {
        while (index > 0 && steps > 0) {
            index--;
            steps--;
        }
        return list.get(index);
    }

    public String forward(int steps) {
        while (index < size - 1 && steps > 0) {
            index++;
            steps--;
        }
        return list.get(index);
    }

}
