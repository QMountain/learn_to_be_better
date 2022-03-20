package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetRow {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }
        List<Integer> list = new ArrayList<>(rowIndex+1);
        list.add(1);
        list.add(1);
        if (rowIndex == 1) {
            return list;
        }
        int row = 2;
        while (row <= rowIndex) {
            List<Integer> newList = new ArrayList<>(row+1);
            newList.add(1);
            for (int i = 0; i < row - 1; i++) {
                newList.add(list.get(i)+list.get(i+1));
            }
            newList.add(1);
            list = newList;
            row++;
        }
        return list;
    }

    public static void main(String[] args) {
        GetRow getRow = new GetRow();
        System.out.println(getRow.getRow(3));
        System.out.println(getRow.getRow(0));
        System.out.println(getRow.getRow(1));
    }
}
