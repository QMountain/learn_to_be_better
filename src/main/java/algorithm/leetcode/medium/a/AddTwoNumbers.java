package algorithm.leetcode.medium.a;

import algorithm.ListNode;

import java.util.Stack;

public class AddTwoNumbers {

    // 题号：2 两数相加 原方法名：addTwoNumbers
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode ans = l1;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int carry = 0;
        while (c1 != null || c2 != null) {
            int v1 = 0;
            if (c1 != null) {
                v1 = c1.val;
            }
            int v2 = 0;
            if (c2 != null) {
                v2 = c2.val;
            }
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            c1.val = sum % 10;
            if (c1.next == null && c2.next == null) {
                if (carry == 1) {
                    c1.next = new ListNode(1);
                }
                return ans;
            }
            if (c1.next == null) {
                c1.next = new ListNode(0);
            }
            c1 = c1.next;
            if (c2.next == null) {
                c2.next = new ListNode(0);
            }
            c2 = c2.next;
        }
        return ans;
    }

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
        ListNode listNode2 = addTwoNumbers.addTwoNumbers2(new ListNode(9,
                        new ListNode(9, new ListNode(9,
                                new ListNode(9, new ListNode(9,
                                        new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9,
                        new ListNode(9, new ListNode(9)))));
        System.out.println(listNode2);
        ListNode listNode1 = addTwoNumbers.addTwoNumbers2(new ListNode(0),
                new ListNode(0));
        System.out.println(listNode1);
        ListNode listNode = addTwoNumbers.addTwoNumbers2(new ListNode(2,
                        new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4))));
        System.out.println(listNode);
        ListNode node = addTwoNumbers.addTwoNumbers(new ListNode(7,
                        new ListNode(2, new ListNode(4, new ListNode(3)))),
                new ListNode(5, new ListNode(6, new ListNode(4))));
        System.out.println(node);
    }
}
