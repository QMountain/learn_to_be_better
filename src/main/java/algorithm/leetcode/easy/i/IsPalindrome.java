package algorithm.leetcode.easy.i;

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

    public boolean isPalindrome(String s) {
        int length = s.length();
        int left = 0;
        int right = length-1;
        while (left <= right) {
            char cLeft = s.charAt(left);
            if (!((cLeft >= 'A' && cLeft <= 'Z')
                    || (cLeft >= 'a' && cLeft <= 'z')
                    ||(cLeft >= '0' && cLeft <= '9'))) {
                left++;
                continue;
            }
            char cRight = s.charAt(right);
            if (!((cRight >= 'A' && cRight <= 'Z')
                    || (cRight >= 'a' && cRight <= 'z')
                    ||(cRight >= '0' && cRight <= '9'))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(cLeft) == Character.toLowerCase(cRight)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        /*System.out.println(isPalindrome.isPalindrome(new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))))));
        System.out.println(isPalindrome.isPalindrome(new ListNode(1, new ListNode(2))));
*/
        //System.out.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome.isPalindrome("1a2"));
    }
}
