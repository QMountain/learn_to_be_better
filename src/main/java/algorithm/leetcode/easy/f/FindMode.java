package algorithm.leetcode.easy.f;

import algorithm.TreeNode;

import java.util.*;

// 这题考的是如何中序遍历，但是空间复杂度是 O(1)
public class FindMode {

    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        getValue(root,map);
        int maxCount = 1;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > maxCount) {
                maxCount = value;
                list = new ArrayList<>();
                list.add(entry.getKey());
            } else if (value == maxCount) {
                list.add(entry.getKey());
            }
        }
        int size = list.size();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void getValue(TreeNode node,Map<Integer,Integer> map) {
        if (node != null) {
            map.put(node.val,map.getOrDefault(node.val,0)+1);
            getValue(node.left,map);
            getValue(node.right,map);
        }
    }

    public static void main(String[] args) {
        FindMode findMode = new FindMode();
        System.out.println(Arrays.toString(findMode.findMode(new TreeNode(1, null,
                new TreeNode(2, new TreeNode(2), null)))));
    }
}
