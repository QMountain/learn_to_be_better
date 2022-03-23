package algorithm.nowcoder;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Merge {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        List<Integer> list = new ArrayList<>();
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                list.add(list2.val);
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                list.add(list1.val);
                list1 = list1.next;
                continue;
            }
            if (list1.val > list2.val) {
                list.add(list2.val);
                list2 = list2.next;
            } else {
                list.add(list1.val);
                list1 = list1.next;
            }
        }
        int size = list.size();
        ListNode node = new ListNode(list.get(size-1));
        for (int i = size-2; i >= 0; i--) {
            node = new ListNode(list.get(i),node);
        }
        return node;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        ListNode node = merge.Merge(new ListNode(1, new ListNode(3, new ListNode(5))),
                new ListNode(2, new ListNode(4, new ListNode(6))));
        System.out.println(node);
    }
}
