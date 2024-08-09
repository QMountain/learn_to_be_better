package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 小朋友来自多少小区
public class Neighborhoods {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getResult(nums));
        } catch (Exception e) {
            System.out.println("0");
        }
    }

    public static int getResult(int[] nums) {
        // num是反馈，cnts[num]是给出相同反馈的（小朋友）数量
        HashMap<Integer, Integer> cnts = new HashMap<>();

        for (int num : nums) {
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }

        // ans 记录题解
        int ans = 0;
        for (int key : cnts.keySet()) {
            // key是反馈，假设某小朋友反馈有key个人和自己一个小区，那么该小区总人数为total = key+1
            int total = key + 1;
            ans += Math.ceil(cnts.get(key) * 1.0 / total) * total;
        }

        return ans;
    }
}
