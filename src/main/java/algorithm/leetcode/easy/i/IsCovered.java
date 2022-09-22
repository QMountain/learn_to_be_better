package algorithm.leetcode.easy.i;

public class IsCovered {

    // 官解 差分数组
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];   // 差分数组
        for (int[] range : ranges) {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }
        // 前缀和
        int curr = 0;
        for (int i = 1; i <= 50; ++i) {
            curr += diff[i];
            if (i >= left && i <= right && curr <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isCovered2(int[][] ranges, int left, int right) {
        for (int[] range : ranges) {
            int min = range[0];
            int max = range[1];
            if (max < left || min > right) {
                continue;
            }
            if (max == left) {
                if (++left > right) {
                    return true;
                }
                continue;
            }
            if (min == right) {
                if (--right < left) {
                    return true;
                }
                continue;
            }
            if (min <= left && right <= max) {
                return true;
            }
            if (min == left) {
                left = max+1;
                if (left > right) {
                    return true;
                }
                continue;
            }
            if (max == right) {
                right = min-1;
                if (right < left) {
                    return true;
                }
                continue;
            }
            if (left < min && max< right) {
                return isCovered(ranges, left, min) && isCovered(ranges, max, right);
            }
            if (left < min) {
                right = min-1;
                continue;
            }
            left = max+1;
        }
        return false;
    }

    public static void main(String[] args) {
        IsCovered isCovered = new IsCovered();
        System.out.println(isCovered.isCovered(new int[][]{{1,9},{2,7},{3,8},{10,12}}, 7, 11));
        System.out.println(isCovered.isCovered(new int[][]{{36,50},{14,28},{4,31},{24,37},{13,36},{27,33},{23,32},{23,27},{1,35}}, 35, 40));
        System.out.println(isCovered.isCovered(new int[][]{{1,10},{10,20}}, 21, 21));
        System.out.println(isCovered.isCovered(new int[][]{{1,2},{3,4},{5,6}}, 2, 5));
    }
}
