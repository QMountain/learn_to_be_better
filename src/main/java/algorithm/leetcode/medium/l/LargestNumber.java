package algorithm.leetcode.medium.l;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        int length = nums.length;
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b)->{
            String s1 = a+""+b;
            String s2 = b+""+a;
            return s2.compareTo(s1);
        });
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        String s = sb.toString();
        while (s.length() > 1 && s.startsWith("0")) {
            s = s.substring(1);
        }
        return s;
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{999999991,9}));
        System.out.println(largestNumber.largestNumber(new int[]{432, 43243}));
        System.out.println(largestNumber.largestNumber(new int[]{10, 2}));
    }
}
