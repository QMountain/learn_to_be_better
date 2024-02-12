package algorithm.leetcode.hard.v;

import algorithm.TreeNode;

import java.util.*;

public class VerticalTraversal {

    // 树中结点数目总数在范围 [1, 1000] 内
    // 0 <= Node.val <= 1000
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ansList = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        addToMap(root, map, 0, 0);
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            List<Integer> colList = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> ent : entry.getValue().entrySet()) {
                colList.addAll(ent.getValue());
            }
            ansList.add(colList);
        }
        return ansList;
    }

    public void addToMap(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, int row, int col) {
        TreeMap<Integer, List<Integer>> colMap = map.getOrDefault(col, new TreeMap<>());
        List<Integer> list = colMap.getOrDefault(row, new LinkedList<>());
        int index = binarySearchIndex(list, root.val);
        list.add(index, root.val);
        colMap.put(row, list);
        map.put(col, colMap);
        if (root.left != null) {
            addToMap(root.left, map, row+1, col-1);
        }
        if (root.right != null) {
            addToMap(root.right, map, row+1, col+1);
        }
    }

    public int binarySearchIndex(List<Integer> baseCol, int target) {
        if (baseCol.isEmpty() || target <= baseCol.get(0)) {
            return 0;
        }
        int size = baseCol.size();
        if (target > baseCol.get(size-1)) {
            return size;
        }
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            Integer element = baseCol.get(mid);
            if (element == target) {
                return mid;
            }
            if (element > target) {
                right = mid;
            } else {
                if (left < mid) {
                    left = mid;
                } else {
                    return right;
                }
            }
        }
        if (baseCol.get(left) >= target) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        VerticalTraversal verticalTraversal = new VerticalTraversal();
        System.out.println(verticalTraversal.verticalTraversal(new TreeNode(3,
                new TreeNode(1, new TreeNode(0), new TreeNode(2)),
                new TreeNode(4, new TreeNode(2), null))));
        System.out.println(verticalTraversal.verticalTraversal(new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)))));
        System.out.println(verticalTraversal.verticalTraversal(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }
}
