package algorithm.leetcode.easy.g;

import algorithm.ListNode;

public class GetDecimalValue {

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans <<= 1;
            ans |= head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        GetDecimalValue getDecimalValue = new GetDecimalValue();
        System.out.println(5 == getDecimalValue.getDecimalValue(new ListNode(1,
                new ListNode(0, new ListNode(1)))));
    }
}
