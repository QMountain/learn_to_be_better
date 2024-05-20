package algorithm.leetcode.medium.f;

import java.util.ArrayList;
import java.util.List;

public class FindCircleNum {

    // 1 <= n <= 200
    // n == isConnected.length
    // n == isConnected[i].length
    // isConnected[i][j] 为 1 或 0
    // isConnected[i][i] == 1
    // isConnected[i][j] == isConnected[j][i]
    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        int ans = 0;
        // i 是起点城市
        for (int i = 0; i < length; i++) {
            // 当前 i 城市没被搜索过
            if (isConnected[i][i] == 1) {
                ans++;
                isConnected[i][i] = 0;
                List<Integer> list = new ArrayList<>();
                list.add(i);
                while (!list.isEmpty()) {
                    List<Integer> next = new ArrayList<>();
                    for (Integer city : list) {
                        for (int j = 0; j < length; j++) {
                            if (isConnected[city][j] == 1) {
                                next.add(j);
                                isConnected[city][j] = 0;
                                isConnected[j][j] = 0;
                                isConnected[j][city] = 0;
                            }
                        }
                    }
                    list = next;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        System.out.println(3 == findCircleNum.findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
        System.out.println(2 == findCircleNum.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
}
