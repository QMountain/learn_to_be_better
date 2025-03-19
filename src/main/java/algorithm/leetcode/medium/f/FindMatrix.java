package algorithm.leetcode.medium.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMatrix {

    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>(length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer lastRowIndex = map.get(num);
                if (ans.size() == lastRowIndex + 1) {
                    ans.add(new ArrayList<>(length));
                }
                ans.get(lastRowIndex+1).add(num);
                map.put(num, lastRowIndex + 1);
            } else {
                if (ans.isEmpty()) {
                    ans.add(new ArrayList<>(length));
                }
                ans.get(0).add(num);
                map.put(num, 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindMatrix findMatrix = new FindMatrix();
        System.out.println(findMatrix.findMatrix(new int[]{1,2,3,4}));
        System.out.println(findMatrix.findMatrix(new int[]{1,3,4,1,2,3,1}));
    }
}
