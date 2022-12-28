package algorithm.leetcode.medium.c;

public class CountHomogenous {

    public int countHomogenous(String s) {
        long bcs = 1000_0000_07;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    l++;
                    i++;
                } else {
                    break;
                }
            }
            if (l == 1) {
                ans++;
            } else {
                long a;
                long b;
                if (l % 2 == 0) {
                    a = l + 1;
                    b = l / 2;
                } else {
                    a = (l + 1) / 2;
                    b = l;
                }
                ans += ((a % bcs) * (b % bcs)) % bcs;
            }
            ans %= bcs;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountHomogenous countHomogenous = new CountHomogenous();
        System.out.println(15 == countHomogenous.countHomogenous("zzzzz"));
        System.out.println(2 == countHomogenous.countHomogenous("xy"));
        System.out.println(13 == countHomogenous.countHomogenous("abbcccaa"));
    }

}
