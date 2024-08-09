package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 停车场车辆统计
public class VehicleStatisticsInParkingLots {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str =
                sc.nextLine()
                        .replaceAll(",", "")
                        .replaceAll("111", "x")
                        .replaceAll("11", "x")
                        .replaceAll("1", "x");

        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
