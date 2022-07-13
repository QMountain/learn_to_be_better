package algorithm.leetcode.medium.n;

public class NextGreaterElement {

    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int length = chars.length;
        int changeIndex = -1;
        for (int i = length-1; i > 0; i--) {
            if (chars[i] > chars[i-1]) {
                changeIndex = i;
                break;
            }
        }
        if (changeIndex == -1) {
            return -1;
        }
        for (int i = length-1; i >= changeIndex; i--) {
            if (chars[i] > chars[changeIndex-1]) {
                char c = chars[i];
                chars[i] = chars[changeIndex-1];
                chars[changeIndex-1] = c;
                for (int j = changeIndex; j < (length+changeIndex)/2 ; j++) {
                    char ch = chars[j];
                    int i1 = length - 1 - (j - changeIndex);
                    chars[j] = chars[i1];
                    chars[i1] = ch;
                }
                break;
            }
        }
        if (length == 10) {
            char[] max = String.valueOf(Integer.MAX_VALUE).toCharArray();
            for (int i = 0; i < 10; i++) {
                if (chars[i] > max[i]) {
                    return -1;
                }
                if (chars[i] < max[i]) {
                    break;
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        System.out.println(nextGreaterElement.nextGreaterElement(2138476986));
        System.out.println(nextGreaterElement.nextGreaterElement(2147483647));
        System.out.println(nextGreaterElement.nextGreaterElement(1024));
        System.out.println(nextGreaterElement.nextGreaterElement(999));
        System.out.println(nextGreaterElement.nextGreaterElement(21));
        System.out.println(nextGreaterElement.nextGreaterElement(12));
    }
}
