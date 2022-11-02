package algorithm.leetcode.medium.f;

import java.util.Arrays;
import java.util.Comparator;

public class FrequencySort {

    public String frequencySort(String s) {
        int[] arr = new int[62];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                arr[c-'0']++;
            } else if (c >= 'a' && c <= 'z') {
                arr[c-'a'+10]++;
            } else {
                arr[c-'A'+36]++;
            }
        }
        Integer[] sortIndex = new Integer[62];
        for (int i = 0; i < 62; i++) {
            sortIndex[i] = i;
        }
        Arrays.sort(sortIndex, Comparator.comparingInt(a -> arr[a]));
        StringBuilder sb = new StringBuilder();
        for (int i = 61; i >= 0; i--) {
            int index = sortIndex[i];
            int count = arr[index];
            char c;
            if (index <= 9) {
                c = (char)('0'+index);
            } else if (index <= 35) {
                c = (char)('a'+index-10);
            } else {
                c = (char)('A'+index-36);
            }
            for (int j = 0; j < count; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        System.out.println(frequencySort.frequencySort("Aabb"));
        System.out.println(frequencySort.frequencySort("cccaaa"));
        System.out.println(frequencySort.frequencySort("tree"));
    }
}
