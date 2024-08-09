package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;

// 靠谱的车
public class ReliableCar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(arr));
    }

    public static int getResult(int[] arr) {
        int correct = 0;

        for (int i = 0; i < arr.length; i++) {
            int fault = arr[i];
            if (fault > 4) fault--;

            for (int j = arr.length - i - 1; j > 0; j--) {
                fault *= 9;
            }

            correct += fault;
        }

        return correct;
    }
}
