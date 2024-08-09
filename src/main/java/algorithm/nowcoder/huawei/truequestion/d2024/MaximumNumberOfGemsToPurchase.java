package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 最多购买宝石数目
public class MaximumNumberOfGemsToPurchase {

    static int n;
    static int[] gems;
    static int v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 橱窗中宝石的总数量
        n = sc.nextInt();

        // n个宝石的价格
        gems = new int[n];
        for (int i = 0; i < n; i++) {
            gems[i] = sc.nextInt();
        }

        // 你拥有的钱
        v = sc.nextInt();

        System.out.println(solution());
    }

    public static int solution() {
        // 记录题解
        int ans = 0;

        // 滑动窗口左右边界
        int l = 0;
        int r = 0;

        // 滑动窗口和
        int window_sum = 0;

        while (r < n) {
            if (window_sum + gems[r] <= v) {
                window_sum += gems[r++];
            } else {
                ans = Math.max(ans, r - l);
                window_sum -= gems[l++];
            }
        }

        // 收尾
        if (window_sum <= v) {
            ans = Math.max(ans, r - l);
        }

        return ans;
    }
}
