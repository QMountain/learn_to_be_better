package algorithm.leetcode.easy;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (!Objects.equals(list.get(i), list.get(size - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))))));
        System.out.println(isPalindrome.isPalindrome(new ListNode(1, new ListNode(2))));
    }
}
