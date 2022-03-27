package algorithm.leetcode.hard;

public class NearestPalindromic {

    public String nearestPalindromic(String n) {
        int length = n.length();
        if (length == 1) {
            return buildPalindromic(Integer.parseInt(n)-1 + "");
        }
        String substring = n.substring(0, length / 2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length / 2; i++) {
            sb.insert(0,substring.charAt(i));
        }
        String res;
        if (length % 2 == 0) {
            res = substring+ sb;
        } else {
            res = substring +n.charAt(length/2)+ sb;
        }
        int dist = Integer.parseInt(res) - Integer.parseInt(n);
        if (dist < 0) {
            return res;
        }
        String newParam = 2*Integer.parseInt(n) - Integer.parseInt(res)+1 +"";
        String s = nearestPalindromic(newParam);
        if (Math.abs(Integer.parseInt(s) - Integer.parseInt(n)) <=
                dist) {
            return s;
        }
        return res;
    }

    public String buildPalindromic(String n) {
        int length = n.length();
        String substring = n.substring(0, length / 2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length / 2; i++) {
            sb.insert(0,substring.charAt(i));
        }
        String res;
        if (length % 2 == 0) {
            res = substring+ sb;
        } else {
            res = substring +n.charAt(length/2)+ sb;
        }
        int dist = Integer.parseInt(res) - Integer.parseInt(n);
        if (dist < 0) {
            return res;
        }
        String newParam = 2*Integer.parseInt(n) - Integer.parseInt(res)+1 +"";
        String s = nearestPalindromic(newParam);
        if (Math.abs(Integer.parseInt(s) - Integer.parseInt(n)) <=
                dist) {
            return s;
        }
        return res;
    }

    public static void main(String[] args) {
        NearestPalindromic nearestPalindromic = new NearestPalindromic();
        System.out.println(nearestPalindromic.nearestPalindromic("10"));
        System.out.println(nearestPalindromic.nearestPalindromic("1213"));
        System.out.println(nearestPalindromic.nearestPalindromic("123"));
        System.out.println(nearestPalindromic.nearestPalindromic("1"));
    }
}
