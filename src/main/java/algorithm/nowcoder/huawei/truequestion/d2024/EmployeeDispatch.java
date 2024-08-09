package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 员工派遣
public class EmployeeDispatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int cntX = sc.nextInt();
        int cntY = sc.nextInt();

        int l = 1;
        int r = (int) Math.pow(10, 9);

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int a = mid / x - mid / (x * y);
            int b = mid / y - mid / (x * y);
            int c = mid / (x * y);

            int d = mid - a - b - c;
            int e = Math.max(0, cntX - b) + Math.max(0, cntY - a);

            if (d >= e) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l);
    }
}
