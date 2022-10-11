package algorithm.leetcode.medium.n;

import algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

public class NumComponents {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        ListNode node = head;
        boolean cnt = false;
        while (node != null) {
            if (set.contains(node.val)) {
                if (!cnt) {
                    cnt = true;
                    ans++;
                }
            } else {
                if (cnt) {
                    cnt = false;
                }
            }
            node = node.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumComponents numComponents = new NumComponents();
        System.out.println(numComponents.numComponents(new ListNode(0, new ListNode(1,
                new ListNode(2, new ListNode(3)))), new int[]{0, 1, 3}));
    }
}
