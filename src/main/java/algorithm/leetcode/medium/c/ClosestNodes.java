package algorithm.leetcode.medium.c;

import algorithm.TreeNode;

import java.util.*;

public class ClosestNodes {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ansList = new ArrayList<>();

        return ansList;
    }

    // 题号 2476 二叉搜索树最近节点查询
    // 直接用了 TreeMap 时间 18.85%  空间 73.77%
    public List<List<Integer>> closestNodeUseTreeMap(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ansList = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        addToMap(root, treeMap);
        for (Integer query : queries) {
            List<Integer> list = new ArrayList<>(2);
            if (treeMap.containsKey(query)) {
                list.add(query);
                list.add(query);
            } else {
                Integer lowerKey = treeMap.lowerKey(query);
                if (lowerKey == null) {
                    list.add(-1);
                } else {
                    list.add(lowerKey);
                }
                Integer higherKey = treeMap.higherKey(query);
                if (higherKey == null) {
                    list.add(-1);
                } else {
                    list.add(higherKey);
                }
            }
            ansList.add(list);
        }
        return ansList;
    }

    public void addToMap(TreeNode root, TreeMap<Integer, Integer> treeMap) {
        treeMap.put(root.val, null);
        if (root.left != null) {
            addToMap(root.left, treeMap);
        }
        if (root.right != null) {
            addToMap(root.right, treeMap);
        }
    }

    public void buildMap(TreeNode root, HashMap<Integer, int[]> map) {
        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            buildMap(root.left, map);
            min = map.get(root.left.val)[0];
        }
        if (root.right != null) {
            buildMap(root.right, map);
            max = map.get(root.right.val)[1];
        }
        map.put(root.val, new int[]{min, max});
    }

    public int lowerValue(TreeNode root, int query) {
        if (root.val > query) {
            if (root.left == null) {
                return -1;
            }
            return lowerValue(root.left, query);
        }
        if (root.right == null) {
            return root.val;
        }
        int lowerValue = lowerValue(root.right, query);
        if (lowerValue == -1) {
            return root.val;
        }
        return lowerValue;
    }

    public int higherValue(TreeNode root, int query) {
        if (root.val == query) {
            return root.val;
        }
        if (root.val > query) {
            if (root.left == null) {
                return root.val;
            }
            int higherValue = higherValue(root.left, query);
            if (higherValue == -1) {
                return root.val;
            }
            return higherValue;
        }
        if (root.right == null) {
            return -1;
        }
        return higherValue(root.right, query);
    }

    public static void main(String[] args) {
        ClosestNodes closestNodes = new ClosestNodes();
        List<Integer> list2 = Arrays.asList(6, 8,14,285508,6);
        System.out.println(closestNodes.closestNodes(new TreeNode(16,
                new TreeNode(8,
                        new TreeNode(1,
                                null,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(7))),
                        new TreeNode(12,
                                new TreeNode(9),
                                null)),
                new TreeNode(18,
                        null,
                        new TreeNode(20))), list2));

        List<Integer> list1 = Collections.singletonList(3);
        System.out.println(closestNodes.closestNodes(
                new TreeNode(4, null, new TreeNode(9)), list1));

        List<Integer> list = Arrays.asList(2,5,16);
        System.out.println(closestNodes.closestNodes(new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(4)),
                new TreeNode(13,
                        new TreeNode(9),
                        new TreeNode(15,
                                new TreeNode(14),
                                null))), list));
    }
}
