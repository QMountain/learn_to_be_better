package algorithm.leetcode.medium.a;

import algorithm.ListNode;

import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode node = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int n1 = 0;
            int n2 = 0;
            if (!stack1.isEmpty()) {
                n1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                n2 = stack2.pop();
            }
            int cal = n1 + n2 + carry;
            node = new ListNode(cal % 10, node);
            carry = cal / 10;
        }
        if (carry == 1) {
            return new ListNode(1,node);
        }
        return node;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node = addTwoNumbers.addTwoNumbers(new ListNode(7,
                        new ListNode(2, new ListNode(4, new ListNode(3)))),
                new ListNode(5, new ListNode(6, new ListNode(4))));
        System.out.println(node);
    }
}
