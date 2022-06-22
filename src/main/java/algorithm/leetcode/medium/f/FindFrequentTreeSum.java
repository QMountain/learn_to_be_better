package algorithm.leetcode.medium.f;

import algorithm.TreeNode;

import java.util.*;

public class FindFrequentTreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        find(root,map);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max,entry.getValue());
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
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

    public int find(TreeNode node, Map<Integer,Integer> map) {
        if (node.left == null && node.right == null) {
            map.put(node.val,map.getOrDefault(node.val,0)+1);
            return node.val;
        }
        int sum = node.val;
        if (node.left != null) {
            int sumLeft = find(node.left,map);
            sum += sumLeft;
        }
        if (node.right != null) {
            int sumRight = find(node.right,map);
            sum += sumRight;
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }

    public static void main(String[] args) {
        FindFrequentTreeSum findFrequentTreeSum = new FindFrequentTreeSum();
        System.out.println(Arrays.toString(findFrequentTreeSum.findFrequentTreeSum(new TreeNode(5,
                new TreeNode(2), new TreeNode(-3)))));
    }

}
