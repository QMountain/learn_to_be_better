package algorithm.leetcode.medium.l;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LenLongestFibSubseq {

    int max;
    Set<Integer> set;

    public int lenLongestFibSubseq(int[] arr) {
        int length = arr.length;
        this.max = arr[length-1];
        set = new HashSet<>(length);
        for (int i : arr) {
            set.add(i);
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                List<Integer> list = getList(arr[i], arr[j]);
                if (list.size() >= 3) {
                    ans = Math.max(ans,list.size());
                }
            }
        }
        return ans;
    }

    public List<Integer> getList(int n1, int n2) {
        List<Integer> list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        int n3 = n1 + n2;
        while (n3 <= max && set.contains(n3)) {
            list.add(n3);
            n1 = n2;
            n2 = n3;
            n3 = n1 + n3;
        }
        return list;
    }

    public static void main(String[] args) {
        LenLongestFibSubseq lenLongestFibSubseq = new LenLongestFibSubseq();
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{1,3,5}));
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    }
}
