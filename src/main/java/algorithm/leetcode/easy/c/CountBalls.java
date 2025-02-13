package algorithm.leetcode.easy.c;

public class CountBalls {

    // 1 <= lowLimit <= highLimit <= 10^5
    public int countBalls(int lowLimit, int highLimit) {
        // 盒子所有可能编号为下标组成的数组
        int[] arr = new int[46];
        // 第一个小球对应的盒子的编号
        int index = sum(lowLimit);
        arr[index]++;
        // 将小球放入对应编号的盒子中
        for (int i = lowLimit + 1; i <= highLimit; i++) {
            // 利用前一个小球对应盒子的编号，
            // 求出后一个小球对应盒子的编号
            int endZeroCount = endZeroCount(i);
            index += 1 - 9 * endZeroCount;
            arr[index]++;
        }
        // 找出最多小球的盒子中的小球数量
        int maxNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }
        return maxNum;
    }
    //数字的各个位之和
    public int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
    //数字末尾连续0的个数
    public int endZeroCount(int num) {
        int endZeroCount = 0;
        while (num % 10 == 0) {
            num = num / 10;
            endZeroCount++;
        }
        return endZeroCount;
    }

}
