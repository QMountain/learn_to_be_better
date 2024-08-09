package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 来自异国的客人
public class GuestsFromForeignCountries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long k = sc.nextLong();
        long n = sc.nextLong();
        long m = sc.nextLong();

        System.out.println(getResult(k, n, m));
    }

    public static long getResult(long k, long n, long m) {
        // 如果幸运数>=进制基数，比如m=2进制，要找n>=2的幸运数，那么肯定是没有的
        if (n >= m) {
            return 0;
        }

        long count = 0;

        // 除留取余
        while (k > 0) {
            long remain = k % m; // 余数就是m进制的每一位上“位值”

            // 按照 m进制的 “位值” 来对比幸运数 n
            if (remain == n) {
                count++;
            }

            k /= m;
        }

        return count;
    }
}
