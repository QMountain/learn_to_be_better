package algorithm.leetcode.medium.f;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        int size = keyList.size();
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Integer a = keyList.get(i);
            Integer value = map.get(a);
            if (value > 0) {
                map.put(a,value-1);
                for (int j = i; j < size; j++) {
                    int b = keyList.get(j);
                    Integer vb = map.get(b);
                    if (vb > 0) {
                        map.put(b,vb-1);
                        for (int k = j; k < size; k++) {
                            int c = keyList.get(k);
                            Integer vc = map.get(c);
                            if (vc > 0) {
                                map.put(c,vc-1);
                                for (int l = k; l < size; l++) {
                                    int d = keyList.get(l);
                                    Integer vd = map.get(d);
                                    if (vd > 0) {
                                        int sum = a + b + c + d;
                                        if (sum == target) {
                                            List<Integer> list = new ArrayList<>(4);
                                            list.add(a);
                                            list.add(b);
                                            list.add(c);
                                            list.add(d);
                                            resList.add(list);
                                        }
                                        if (sum > target) {
                                            break;
                                        }
                                    }
                                }
                                map.put(c,vc);
                            }
                        }
                        map.put(b,vb);
                    }
                }
                map.put(a,value);
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }
}
