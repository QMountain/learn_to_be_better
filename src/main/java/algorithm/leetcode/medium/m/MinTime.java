package algorithm.leetcode.medium.m;

public class MinTime {

    /**
     * 3494. 酿造药水需要的最少总时间
     * 给你两个长度分别为 n 和 m 的整数数组 skill 和 mana 。
     * 在一个实验室里，有 n 个巫师，他们必须按顺序酿造 m 个药水。
     * 每个药水的法力值为 mana[j]，并且每个药水 必须 依次通过 所有 巫师处理，
     * 才能完成酿造。第 i 个巫师在第 j 个药水上处理需要的时间为 timeij = skill[i] * mana[j]。
     * 由于酿造过程非常精细，药水在当前巫师完成工作后 必须 立即传递给下一个巫师并开始处理。
     * 这意味着时间必须保持 同步，确保每个巫师在药水到达时 马上 开始工作。
     * 返回酿造所有药水所需的 最短 总时间。
     * n == skill.length
     * m == mana.length
     * 1 <= n, m <= 5000
     * 1 <= mana[i], skill[i] <= 5000
     */
    public long minTime(int[] skill, int[] mana) {
        int length = skill.length;
        long[] arr = new long[length];
        arr[0] = (long) skill[0] * mana[0];
        for (int i = 1; i < length; i++) {
            arr[i] = arr[i - 1] + ((long) skill[i] * mana[0]);
        }
        long lastDiff = 0;
        long diff = 0;
        for (int i = 1; i < mana.length; i++) {
            int m = mana[i];
            long[] curr = new long[length];
            curr[0] = (long) skill[0] * m + arr[0];
            for (int j = 1; j < skill.length; j++) {
                curr[j] = (long) skill[j] * m + curr[j-1];
                if (curr[j - 1] + diff < arr[j] + lastDiff) {
                    diff += arr[j] + lastDiff - (curr[j - 1] + diff);
                }
            }
            arr = curr;
            lastDiff = diff;
        }
        return arr[length-1] + diff;
    }

    public static void main(String[] args) {
        MinTime minTime = new MinTime();
        /**
         * 5        30          40          60      [mana = 5]
         * 53       58          60          64      [mana = 1]
         * 58       78          86          102      [mana = 4]
         * 88       98          102         110     [mana = 2]
         */
        System.out.println(110 == minTime.minTime(
                new int[]{1,5,2,4}, new int[]{5,1,4,2}));
        System.out.println(5 == minTime.minTime(
                new int[]{1,1,1}, new int[]{1,1,1}));
        System.out.println(21 == minTime.minTime(
                new int[]{1,2,3,4}, new int[]{1,2}));
    }
}
