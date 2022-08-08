package algorithm.leetcode.medium.s;

import algorithm.ListNode;
import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        int size = values.size();
        if (size > 0) {
            int mid = size /2;
            TreeNode root = new TreeNode(values.get(mid));
            if (0 <= mid-1) {
                root.left = build(values,0,mid-1);
            }
            if (mid+1 <= size-1) {
                root.right = build(values,mid+1, size -1);
            }
            return root;
        }
        return null;
    }

    public TreeNode build(List<Integer> values, int left, int right) {
        if (left == right) {
            return new TreeNode(values.get(left));
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(values.get(mid));
        if (left <= mid-1) {
            root.left = build(values,left,mid-1);
        }
        if (mid+1 <= right) {
            root.right = build(values,mid+1,right);
        }
        return root;
    }

    public static void main(String[] args) {
        SortedListToBST sortedListToBST = new SortedListToBST();
        TreeNode treeNode = sortedListToBST.sortedListToBST(new ListNode(-10,
                new ListNode(-3, new ListNode(0,
                        new ListNode(5, new ListNode(9))))));
        System.out.println(treeNode);
    }
}
