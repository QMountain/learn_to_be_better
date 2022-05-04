package algorithm.leetcode.medium.f;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinner {

    public int findTheWinner(int n, int k) {
        if (k == 1) {
            return n;
        }
        if (n == 1) {
            return 1;
        }
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        int startIndex;
        int pIndex = 1;
        int count = 2;
        while (true) {
           while (count < k) {
               if (pIndex == list.size()-1) {
                   pIndex = 0;
               } else {
                   pIndex++;
               }
               count++;
           }
           list.remove(pIndex);
           if (pIndex == list.size()) {
               startIndex = 0;
           } else {
               startIndex = pIndex;
           }
           if (startIndex == list.size()-1) {
               pIndex = 0;
           } else {
               pIndex = startIndex + 1;
           }
           if (startIndex == pIndex) {
               return list.get(0);
           }
           count = 2;
        }

    }

    public static void main(String[] args) {
        FindTheWinner findTheWinner = new FindTheWinner();
        System.out.println(findTheWinner.findTheWinner(6, 5));
        System.out.println(findTheWinner.findTheWinner(5, 2));
    }
}
