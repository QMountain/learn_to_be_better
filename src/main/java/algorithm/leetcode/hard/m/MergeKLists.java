package algorithm.leetcode.hard.m;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int length = lists.length;
        List<Integer> sortedList = new ArrayList<>();

        boolean canContinue = true;
        while (canContinue) {

            int tempMin = 0;
            int minIndex = 0;
            for (int i = 0; i < length; i++) {
                if (lists[i] != null) {
                    tempMin = lists[i].val;
                    minIndex = i;
                    break;
                }
            }

            for (int i = 0; i < length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val <= tempMin) {
                        tempMin = lists[i].val;
                        minIndex = i;
                    }
                }
            }
            sortedList.add(tempMin);
            if (lists[minIndex] != null) {
                lists[minIndex] = lists[minIndex].next;
            } else {
                return null;
            }

            boolean allNull = true;
            for (ListNode list : lists) {
                if (list != null) {
                    allNull = false;
                    break;
                }
            }
            canContinue = !allNull;
        }

        int size = sortedList.size();
        ListNode node = new ListNode(sortedList.get(size-1));
        for (int i = size-2; i >= 0; i--) {
            node = new ListNode(sortedList.get(i),node);
        }
        return node;
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        System.out.println(mergeKLists.mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))}));
        System.out.println(mergeKLists.mergeKLists(new ListNode[]{new ListNode()}));
    }
}
