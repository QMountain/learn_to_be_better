package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 素数之积
public class ProductOfPrimeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextInt()));
    }

    // 求解素数之积
    public static String getResult(int n) {
        // 如果n为素数，则必然不可能是两个素数之积
        if (isPrime(n)) {
            return "-1 -1";
        }

        // 假设i为n的因子
        for (int i = 2; i < Math.sqrt(n); i++) {
            // 若n不能整除i,则i不是n的因子，继续下次循环，找新的i
            // 若n可以整除i,则i就是n的因子
            if (n % i == 0) {
                // j为n的另一因子
                int j = n / i;

                // 只有i,j因子都为素数时，n才是符合题意的素数之积
                if (isPrime(i) && isPrime(j)) {
                    // 如果n为两个素数之积，则n只能分解为这两个因子，因为素数无法再次分解出其他因子，也就是说n不再有其他因子了（因子不包含1和自身）
                    return i < j ? i + " " + j : j + " " + i;
                } else {
                    // 如果i，j有一个不是素数因子，则说明n存在非素数因子，此时n不可能是素数之积
                    // 此时可以判定n不符合要求了，直接退出循环
                    break;
                }
            }
        }

        return "-1 -1";
    }

    // 判断n是否为素数
    public static boolean isPrime(int n) {
        if (n <= 3) return n > 1;

        if (n % 6 != 1 && n % 6 != 5) return false;

        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
