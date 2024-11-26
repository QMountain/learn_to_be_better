package algorithm.leetcode.easy.n;

public class NumberOfAlternatingGroups {

    // 3 <= colors.length <= 100
    // 0 <= colors[i] <= 1
    public int numberOfAlternatingGroups(int[] colors) {
        int ans = 0;
        int length = colors.length;
        if (colors[0] != colors[length-1]) {
            ans += colors[0] != colors[1] ? 1 : 0;
            ans += colors[length-1] != colors[length-2] ? 1 : 0;
        }
        for (int i = 1; i < length - 1; i++) {
            if (colors[i] != colors[i-1] && colors[i] != colors[i+1]) {
                ans++;
            }
        }
        return ans;
    }

}
