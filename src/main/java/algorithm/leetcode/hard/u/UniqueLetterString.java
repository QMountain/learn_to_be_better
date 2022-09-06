package algorithm.leetcode.hard.u;

import java.util.ArrayList;
import java.util.List;

public class UniqueLetterString {

    List<List<Integer>> indexList;

    public int uniqueLetterString(String s) {
        int length = s.length();
        indexList = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            indexList.add(new ArrayList<>());
        }
        for (int i = 0; i < length; i++) {
            indexList.get(s.charAt(i)-'A').add(i);
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int leftLength;
            int pl = binarySearch(c - 'A', i);
            if (pl > 0) {
                leftLength = i- indexList.get(c-'A').get(pl-1)-1;
            } else {
                leftLength = i;
            }
            int rightLength;
            if (pl < indexList.get(c-'A').size()-1) {
                rightLength = indexList.get(c-'A').get(pl+1) - i-1;
            } else {
                rightLength = length-1 - i;
            }
            ans += (leftLength+1) * (rightLength +1);
        }
        return ans;
    }

    public int binarySearch(int index, int target) {
        List<Integer> list = indexList.get(index);
        int left = 0;
        int right = list.size()-1;
        while (left < right) {
            int mid = (left+right)/2;
            Integer v = list.get(mid);
            if (v == target) {
                return mid;
            } else if (v > target) {
                right = mid;
            } else {
                if (left == mid) {
                    left++;
                } else {
                    left = mid;
                }
            }
        }
        return left;
    }

    public int uniqueLetterString2(String s) {
        int length = s.length();
        int ans = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int leftLength = 0;
            for (int j = i-1; j >= 0; j--) {
                if (s.charAt(j) == c) {
                    break;
                } else {
                    leftLength++;
                }
            }
            int rightLength = 0;
            for (int j = i+1; j < length; j++) {
                if (s.charAt(j) == c) {
                    break;
                } else {
                    rightLength++;
                }
            }
            ans += (leftLength+1) * (rightLength +1);
        }
        return ans;
    }

    public static void main(String[] args) {
        UniqueLetterString uniqueLetterString = new UniqueLetterString();
        System.out.println(92 == uniqueLetterString.uniqueLetterString("LEETCODE"));
        System.out.println(8 == uniqueLetterString.uniqueLetterString("ABA"));
        System.out.println(10 == uniqueLetterString.uniqueLetterString("ABC"));
    }

}
