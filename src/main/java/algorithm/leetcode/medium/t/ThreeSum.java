package algorithm.leetcode.medium.t;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return new ArrayList<>();
        }
        Map<Integer,Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Integer> keySet = map.keySet();
        List<Integer> list = new ArrayList<>(keySet);
        int size = list.size();
        if (list.get(0) > 0 || list.get(size-1) < 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Set<String> checkSet = new HashSet<>();
        Integer countOfZero = map.getOrDefault(0, 0);
        if (countOfZero > 2) {
            checkSet.add("0,0,0");
            List<Integer> l = new ArrayList<>(3);
            l.add(0);
            l.add(0);
            l.add(0);
            res.add(l);
        }
        if (countOfZero > 0) {
            map.put(0,1);
        }

        int last = list.get(size-1);
        if (map.get(last) > 1) {
            if (keySet.contains(-last*2)) {
                checkSet.add(String.format("%s,%s,%s",-last*2,last,last));
                List<Integer> l = new ArrayList<>(3);
                l.add(-last*2);
                l.add(last);
                l.add(last);
                res.add(l);
            }
        }

        for (int i = 0; i < size - 1; i++) {
            int key = list.get(i);
            if (map.get(key) > 1 && key != 0) {
                if (keySet.contains(-key*2)) {
                    checkSet.add(String.format("%s,%s,%s",key,key,-key*2));
                    List<Integer> l = new ArrayList<>(3);
                    l.add(key);
                    l.add(key);
                    l.add(-key*2);
                    res.add(l);
                }
            }
            for (int j = i+1; j < size; j++) {
                Integer a = list.get(i);
                Integer b = list.get(j);
                int x = -list.get(i)-list.get(j);
                if (a < x && b < x && keySet.contains(x)) {
                    String s = String.format("%s,%s,%s",a,b,x);
                    if (!checkSet.contains(s)) {
                        List<Integer> l = new ArrayList<>(3);
                        l.add(a);
                        l.add(b);
                        l.add(x);
                        res.add(l);
                        checkSet.add(s);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum.threeSum(new int[]{}));
        System.out.println(threeSum.threeSum(new int[]{0}));
        System.out.println(threeSum.threeSum(new int[]{0,0,0}));
        System.out.println(threeSum.threeSum(new int[]{1,1,-2}));
        System.out.println(threeSum.threeSum(new int[]{-1,0,1}));
    }
}
