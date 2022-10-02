package algorithm.leetcode.easy.g;

public class GetMinimumTime {

    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int ans = 0;
        for (int[] fruit : fruits) {
            int type = fruit[0];
            int num = fruit[1];
            if (num % limit == 0) {
                ans += num / limit * time[type];
            } else {
                ans += (num / limit + 1) * time[type];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GetMinimumTime getMinimumTime = new GetMinimumTime();
        System.out.println(5 == getMinimumTime.getMinimumTime(new int[]{1}, new int[][]{{0,3},{0,5}}, 2));
        System.out.println(10 == getMinimumTime.getMinimumTime(new int[]{2, 3, 2}, new int[][]{{0,2},{1,4},{2,1}}, 3));
    }
}
