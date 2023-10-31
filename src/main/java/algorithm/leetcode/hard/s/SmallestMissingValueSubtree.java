package algorithm.leetcode.hard.s;

import java.util.*;

public class SmallestMissingValueSubtree {

    // n == parents.length == nums.length
    // 2 <= n <= 10^5
    // 对于 i != 0 ，满足 0 <= parents[i] <= n - 1
    // parents[0] == -1
    // parents 表示一棵合法的树。
    // 1 <= nums[i] <= 10^5
    // nums[i] 互不相同
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int length = parents.length;
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Node node = new Node();
            node.code = i;
            LinkedList<int[]> geneSegList = new LinkedList<>();
            geneSegList.addLast(new int[]{nums[i], nums[i]});
            node.geneSegList = geneSegList;
            nodeMap.put(i, node);
        }
        for (int i = 1; i < length; i++) {
            Node node = nodeMap.get(parents[i]);
            HashSet<Node> children = node.children;
            if (children == null) {
                children = new HashSet<>();
            }
            children.add(nodeMap.get(i));
            node.children = children;
        }
        int[] ans = new int[length];
        cleanNodeAndSignToAns(ans, nodeMap.get(0));
        return ans;
    }

    public LinkedList<int[]> combineTwo(LinkedList<int[]> list1, LinkedList<int[]> list2) {
        LinkedList<int[]> res = new LinkedList<>();
        while (!list1.isEmpty() || !list2.isEmpty()) {
            if (list1.isEmpty()) {
                int[] seg2 = list2.pollFirst();
                if (res.isEmpty()) {
                    res.addLast(seg2);
                } else {
                    int[] last = res.peekLast();
                    if (last[1] + 1 < seg2[0]) {
                        res.addLast(seg2);
                    } else {
                        last[1] = seg2[1];
                    }
                }
            } else if (list2.isEmpty()) {
                int[] seg1 = list1.pollFirst();
                if (res.isEmpty()) {
                    res.addLast(seg1);
                } else {
                    int[] last = res.peekLast();
                    if (last[1] + 1 < seg1[0]) {
                        res.addLast(seg1);
                    } else {
                        last[1] = seg1[1];
                    }
                }
            } else {
                int[] seg1 = list1.peekFirst();
                int[] seg2 = list2.peekFirst();
                int[] addSeg;
                if (seg1[0] < seg2[0]) {
                    addSeg = seg1;
                    list1.pollFirst();
                } else {
                    addSeg = seg2;
                    list2.pollFirst();
                }
                if (res.isEmpty()) {
                    res.addLast(addSeg);
                } else {
                    int[] last = res.peekLast();
                    if (last[1] + 1 < addSeg[0]) {
                        res.addLast(addSeg);
                    } else {
                        last[1] = addSeg[1];
                    }
                }
            }
        }
        return res;
    }

    public void cleanNodeAndSignToAns(int[] ans, Node node) {
        HashSet<Node> children = node.children;
        if (children != null) {
            for (Node child : children) {
                cleanNodeAndSignToAns(ans, child);
                node.geneSegList = combineTwo(node.geneSegList, child.geneSegList);
            }
        }
        int value = getSmallestMissingValueFromTreeSet(node.geneSegList);
        ans[node.code] = value;
    }

    public int getSmallestMissingValueFromTreeSet(LinkedList<int[]> geneSegList) {
        int[] firstSeg = geneSegList.peekFirst();
        int first = firstSeg[0];
        if (first > 1) {
            return 1;
        }
        return firstSeg[1] + 1;
    }

    public static class Node {
        int code;
        HashSet<Node> children;
        LinkedList<int[]> geneSegList;
    }

    public static void main(String[] args) {
        SmallestMissingValueSubtree smallestMissingValueSubtree = new SmallestMissingValueSubtree();
        System.out.println(Arrays.toString(smallestMissingValueSubtree.smallestMissingValueSubtree(
                new int[]{-1,0,0,0,2}, new int[]{6,4,3,2,1})));
        System.out.println(Arrays.toString(smallestMissingValueSubtree.smallestMissingValueSubtree(
                new int[]{-1,0,0,2}, new int[]{5,3,2,1})).equals("[4, 1, 3, 2]"));
        System.out.println(Arrays.toString(smallestMissingValueSubtree.smallestMissingValueSubtree(
                new int[]{-1,0,1,0,3,3}, new int[]{5,4,6,2,1,3})));
        System.out.println(Arrays.toString(smallestMissingValueSubtree.smallestMissingValueSubtree(
                new int[]{-1,0,0,2}, new int[]{1,2,3,4})));
    }
}
