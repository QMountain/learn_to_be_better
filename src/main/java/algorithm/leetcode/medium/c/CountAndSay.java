package algorithm.leetcode.medium.c;

public class CountAndSay {

    public String countAndSay(int n) {
        String str = "1";
        while (--n > 0) {
            str = getNext(str);
        }
        return str;
    }

    public String getNext(String str) {
        int length = str.length();
        if (length == 1) {
            return "11";
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                count++;
                if (i+1 == length) {
                    sb.append(count).append(str.charAt(i - 1));
                    break;
                }
            } else {
                sb.append(count).append(str.charAt(i - 1));
                if (i+1 == length) {
                    sb.append(1).append(str.charAt(i));
                    break;
                }
                count = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println("312211".equals(countAndSay.countAndSay(6)));
        System.out.println("111221".equals(countAndSay.countAndSay(5)));
        System.out.println("1211".equals(countAndSay.countAndSay(4)));
        System.out.println(countAndSay.countAndSay(1));
    }
}
