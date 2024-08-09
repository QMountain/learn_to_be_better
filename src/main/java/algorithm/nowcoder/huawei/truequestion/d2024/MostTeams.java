package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;

// 求最多可以派出多少支团队
public class MostTeams {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] capacities =
                Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int minCap = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(n, capacities, minCap));
    }

    public static int getResult(int n, int[] capacities, int minCap) {
        // 升序
        Arrays.sort(capacities);

        int l = 0;
        int r = n - 1;

        // 记录题解
        int ans = 0;

        // 单人组队
        while (r >= l && capacities[r] >= minCap) {
            r--;
            ans++;
        }

        // 双人组队
        while (l < r) {
            int sum = capacities[l] + capacities[r];

            // 如果两个人的能力值之和>=minCap，则组队
            if (sum >= minCap) {
                ans++;
                l++;
                r--;
            } else {
                // 否则将能力低的人剔除，换下一个能力更高的人
                l++;
            }
        }

        return ans;
    }

}
