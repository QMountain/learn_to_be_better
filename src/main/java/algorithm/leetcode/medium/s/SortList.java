package algorithm.leetcode.medium.s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        ListNode node = new ListNode(arr[size-1]);
        for (int i = size-2; i >= 0; i--) {
            node = new ListNode(arr[i],node);
        }
        return node;
    }

}
