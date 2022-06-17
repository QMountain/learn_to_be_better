package algorithm.leetcode.hard.n;

public class NearestPalindromic {

    public String nearestPalindromic(String n) {
        int length = n.length();
        char[] chars = n.toCharArray();
        boolean isPalindromic = true;
        for (int i = 0; i < length / 2; i++) {
            if (chars[length-1-i] != chars[i]) {
                isPalindromic = false;
                break;
            }
        }
        if (isPalindromic) {
            if (length % 2 == 0) {

            }
        }
        if (length < 3) {
            int num = Integer.parseInt(n);
            if (num <= 10) {
                return String.valueOf(num-1);
            }
            if (num == 11) {
                return "9";
            }
            if (num == 99) {
                return "101";
            }
            if (n.charAt(0) == n.charAt(1)) {
                String s = String.valueOf(Integer.parseInt(n.charAt(0) + "") - 1);
                return s+s;
            }

        }
        if (length % 2 == 0) {

            for (int i = 0; i < length / 2 - 1; i++) {
                chars[length-1-i] = chars[i];
            }
            int min = Math.min(chars[length / 2], chars[length / 2 - 1]);
            chars[length/2] = (char) min;
            chars[length/2-1] = (char) min;
            return new String(chars);
        }

        for (int i = 0; i < length / 2; i++) {
            chars[length-1-i] = chars[i];
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        NearestPalindromic nearestPalindromic = new NearestPalindromic();
        System.out.println(nearestPalindromic.nearestPalindromic("10"));
        System.out.println(nearestPalindromic.nearestPalindromic("1213"));
        System.out.println(nearestPalindromic.nearestPalindromic("123"));
        System.out.println(nearestPalindromic.nearestPalindromic("1"));
    }
}
