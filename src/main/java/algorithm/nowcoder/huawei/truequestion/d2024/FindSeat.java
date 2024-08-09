package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 找座位
public class FindSeat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine().toCharArray()));
    }

    public static int getResult(char[] desk) {
        int ans = 0;
        for (int i = 0; i < desk.length; i++) {
            if (desk[i] == '0') {
                boolean isLeftEmpty = i == 0 || desk[i - 1] == '0';
                boolean isRightEmpty = i == desk.length - 1 || desk[i + 1] == '0';
                if (isLeftEmpty && isRightEmpty) {
                    ans++;
                    desk[i] = '1';
                    i++;
                }
            }
        }

        return ans;
    }

}
