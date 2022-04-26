package algorithm.leetcode.medium.r;

import java.util.*;

/**
 * @ClassName RandomFlipMatrix
 * @Description  随机翻转矩阵
 * @Author qsf
 * Date   2021-11-27  23:56
 */
public class RandomFlipMatrix {

    int m;
    int n;
    // 存的是已经变为1的位置
    Set<Integer> changedPosition = new TreeSet<>();
    Random random = new Random();

    public RandomFlipMatrix(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int[] flip() {
        int count = m * n;

        // 这次要把第几个0改为1
        int position;
        if (count - changedPosition.size() == 1) {
            position = 1;
        } else {
            position = random.nextInt(count - changedPosition.size() - 1) + 1;
        }

        if (changedPosition.size() != 0) {
            List<Integer> c = new ArrayList<>(changedPosition);
            for (int i = 0; i < c.size(); i++) {
                Integer cp = c.get(i);

                // 如果position 与已经变为1的位置撞上了，或者这个位置前面有已经变为1的，就往后移动一位
                if (cp <= position) {
                    position++;
                }
            }
        }

        int i;
        int j;
        if (position % n == 0) {
            i = position / n - 1;
            j = n - 1;
        } else {
            i = position / n;
            j = position % n - 1;
        }

        changedPosition.add(i*n+j+1);

        return new int[]{i,j};
    }

    public void reset() {
        changedPosition = new TreeSet<>();
    }

    public static void main(String[] args) {
        RandomFlipMatrix randomFlipMatrix = new RandomFlipMatrix(5, 5);
        for (int i = 0; i < 20; i++) {
            //randomFlipMatrix.reset();
            int[] flip1 = randomFlipMatrix.flip();
            System.out.println(Arrays.toString(flip1));
        }
    }
}
