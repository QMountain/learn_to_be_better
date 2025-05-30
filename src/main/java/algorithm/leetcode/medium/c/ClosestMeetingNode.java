package algorithm.leetcode.medium.c;

import java.util.HashSet;
import java.util.Set;

public class ClosestMeetingNode {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2) {
            return node1;
        }
        Set<Integer> set1 = new HashSet<>();
        set1.add(node1);
        Set<Integer> set2 = new HashSet<>();
        set2.add(node2);
        while (true) {
            boolean circle1 = false;
            Integer ans1 = null;
            if (edges[node1] != -1) {
                set1.add(edges[node1]);
                if (set2.contains(edges[node1])) {
                    ans1 = edges[node1];
                }
                node1 = edges[node1];
                circle1 = set1.contains(edges[node1]);
            } else {
                circle1 = true;
            }
            boolean circle2 = false;
            Integer ans2 = null;
            if (edges[node2] != -1) {
                set2.add(edges[node2]);
                if (set1.contains(edges[node2])) {
                    ans2 = edges[node2];
                }
                node2 = edges[node2];
                circle2 = set2.contains(edges[node2]);
            } else {
                circle2 = true;
            }
            if (ans1 != null && ans2 != null) {
                return Math.min(ans1, ans2);
            } else if (ans1 != null) {
                return ans1;
            } else if (ans2 != null) {
                return ans2;
            }
            if (circle1 && circle2) {
                return -1;
            }
            if (edges[node1] == -1 && edges[node2] == -1) {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        ClosestMeetingNode closestMeetingNode = new ClosestMeetingNode();
        System.out.println(1 == closestMeetingNode.closestMeetingNode(
                new int[]{4,4,8,-1,9,8,4,4,1,1}, 5, 6));
        System.out.println(-1 == closestMeetingNode.closestMeetingNode(
                new int[]{5,4,5,4,3,6,-1}, 0, 1));
        System.out.println(0 == closestMeetingNode.closestMeetingNode(
                new int[]{5,-1,3,4,5,6,-1,-1,4,3}, 0, 0));
        System.out.println(2 == closestMeetingNode.closestMeetingNode(
                new int[]{1,2,-1}, 0, 2));
        System.out.println(2 == closestMeetingNode.closestMeetingNode(
                new int[]{2,2,3,-1}, 0, 1));
    }
}
