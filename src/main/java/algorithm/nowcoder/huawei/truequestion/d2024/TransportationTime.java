package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 运输时间
public class TransportationTime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        // 记录前车到达终点的时刻，本题后车不可能比前车更早到达，因此如果后车到达时刻 < 前车到达时刻arrived，则后车也是按照前车arrived时刻达到
        double arrived = 0;

        for (int i = 0; i < m; i++) {
            // 当前车的速度
            double speed = sc.nextDouble();
            // 当前车到达终点的时刻
            // * 当前车如果比前车更早到达，则被前车阻碍，按前车到达时间算
            // * 当前车如果比前车更晚到达，则不被前车阻碍，按后车到达时间算
            arrived = Math.max(arrived, n / speed + i); // n*1.0/speed是行驶花费时间； i是第i辆车的出发时间
        }

        // 到达时刻 - 出发时刻 = 路上花费的时间
        double cost = arrived - (m - 1);

        System.out.println(cost);// 实际考试没有精度问题，可以直接输出cost，可以满分

        // 我这边OJ用例设计时有小数位则至多保留3位
        // 格式化打印小数
//        NumberFormat nf = NumberFormat.getInstance();
//        nf.setMinimumFractionDigits(0); // 没有小数位则不保留
//        nf.setMaximumFractionDigits(3); // 有小数位则至多保留3位
//
//        System.out.println(nf.format(cost));
    }
}
