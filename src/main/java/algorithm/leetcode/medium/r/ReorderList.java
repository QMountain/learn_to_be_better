package algorithm.leetcode.medium.r;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        if (list.size() == 1) {
            return;
        }
        List<ListNode> reorder = new ArrayList<>();
        int left = 0;
        int right = list.size()-1;
        while (left < right) {
            reorder.add(list.get(left++));
            reorder.add(list.get(right--));
        }
        if (list.size() % 2 != 0) {
            reorder.add(list.get(left));
        }
        for (int i = 0; i < reorder.size()-1; i++) {
            reorder.get(i).next = reorder.get(i+1);
        }
        reorder.get(reorder.size()-1).next = null;
        head.next = reorder.get(1);
    }

}
