package algorithm.leetcode.easy;

public class ToHex {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i --) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public void addChar(StringBuilder sb,int n) {
        if (n <= 9) {
            sb.insert(0,n);
        } else if (n == 10) {
            sb.insert(0,'a');
        } else if (n == 11) {
            sb.insert(0,'b');
        } else if (n == 12) {
            sb.insert(0,'c');
        } else if (n == 13) {
            sb.insert(0,'d');
        } else if (n == 14) {
            sb.insert(0,'e');
        } else {
            sb.insert(0,'f');
        }
    }

    public static void main(String[] args) {
        ToHex toHex = new ToHex();
        System.out.println(toHex.toHex(26));
        System.out.println(toHex.toHex(-1));
    }
}
