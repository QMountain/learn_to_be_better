package algorithm.leetcode.easy.u;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UnequalTriplets {

    public int unequalTriplets(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int res = 0, n = nums.length, t = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += t * entry.getValue() * (n - t - entry.getValue());
            t += entry.getValue();
        }
        return res;
    }

    public int unequalTriplets2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i).getValue();
            for (int j = i+1; j < list.size(); j++) {
                int b = list.get(j).getValue();
                for (int k = j+1; k < list.size(); k++) {
                    int c = list.get(k).getValue();
                    ans += a*b*c;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        UnequalTriplets unequalTriplets = new UnequalTriplets();
        System.out.println(0 == unequalTriplets.unequalTriplets(new int[]{1,1,1,1,1}));
        System.out.println(3 == unequalTriplets.unequalTriplets(new int[]{4,4,2,4,3}));
    }
}
