package algorithm.leetcode.easy.g;

import java.util.Arrays;

public class GenerateTheString {

    public String generateTheString(int n) {
        char[] res = new char[n];
        Arrays.fill(res,'a');
        if (n % 2 == 0) {
            res[n-1] = 'b';
        }
        return String.valueOf(res);
    }
}
