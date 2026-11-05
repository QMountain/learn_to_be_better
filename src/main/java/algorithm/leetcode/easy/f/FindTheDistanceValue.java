package algorithm.leetcode.easy.f;

import java.util.TreeSet;

public class FindTheDistanceValue {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr2) {
            set.add(i);
        }
        int ans = 0;
        for (int i : arr1) {
            if (set.contains(i)) {
                continue;
            }
            Integer lower = set.lower(i);
            if (lower != null && i - lower <= d) {
                continue;
            }
            Integer higher = set.higher(i);
            if (higher != null && higher - i <= d) {
                continue;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheDistanceValue findTheDistanceValue = new FindTheDistanceValue();
        System.out.println(1 == findTheDistanceValue.findTheDistanceValue(new int[]{2,6},
                new int[]{-10, 9, 2, -1}, 2));
    }
}
