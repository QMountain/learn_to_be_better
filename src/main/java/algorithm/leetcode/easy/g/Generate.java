package algorithm.leetcode.easy.g;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<>(numRows);
        resList.add(Collections.singletonList(1));
        if (numRows == 1) {
            return resList;
        }
        List<Integer> list2 = new ArrayList<>(2);
        list2.add(1);
        list2.add(1);
        resList.add(list2);
        if (numRows == 2) {
            return resList;
        }
        int size = 3;
        while (size <= numRows) {
            List<Integer> list = new ArrayList<>(size);
            list.add(1);
            List<Integer> lastList = resList.get(size - 2);
            for (int i = 0; i < size - 2; i++) {
                list.add(lastList.get(i)+lastList.get(i+1));
            }
            list.add(1);
            resList.add(list);
            size++;
        }
        return resList;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        System.out.println(generate.generate(5));
        System.out.println(generate.generate(1));
    }
}
