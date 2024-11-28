package algorithm.leetcode.medium.n;

public class NumberOfAlternatingGroups {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int length = colors.length;
        int ans = 0;
        int read = 0;
        for (int i = 0; i < length; i++) {
            read = Math.max(read, i);
            while (read - i + 1 < k) {
                if (colors[(read+1)%length] != colors[read%length]) {
                    read++;
                } else {
                    break;
                }
            }
            if (read - i + 1 >= k) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfAlternatingGroups numberOfAlternatingGroups = new NumberOfAlternatingGroups();
        System.out.println(2 == numberOfAlternatingGroups.numberOfAlternatingGroups(
                new int[]{0,1,0,0,1,0,1}, 6));
        System.out.println(3 == numberOfAlternatingGroups.numberOfAlternatingGroups(
                new int[]{0, 1, 0, 1, 0}, 3));
    }
}
