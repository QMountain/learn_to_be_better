package algorithm.leetcode.hard.n;

public class NumberOfPowerfulInt {

    /**
     * 给你三个整数 start ，finish 和 limit 。同时给你一个下标从 0 开始的字符串 s ，表示一个 正 整数。
     * 如果一个 正 整数 x 末尾部分是 s （换句话说，s 是 x 的 后缀），
     * 且 x 中的每个数位至多是 limit ，那么我们称 x 是 强大的 。
     * 请你返回区间 [start..finish] 内强大整数的 总数目 。
     * 如果一个字符串 x 是 y 中某个下标开始（包括 0 ），到下标为 y.length - 1 结束的子字符串，
     * 那么我们称 x 是 y 的一个后缀。比方说，25 是 5125 的一个后缀，但不是 512 的后缀。
     * 1 <= start <= finish <= 10^15
     * 1 <= limit <= 9
     * 1 <= s.length <= floor(log10(finish)) + 1
     * s 数位中每个数字都小于等于 limit 。
     * s 不包含任何前导 0 。
     */
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long curr = Long.parseLong(s);
        if (curr > finish) {
            return 0;
        }
        String finishStr = String.valueOf(finish);
        int finishLength = finishStr.length();
        if (finishLength == s.length()) {
            if (curr < start) {
                return 0;
            }
            return 1;
        }
        String startStr = String.valueOf(start);
        int startLength = startStr.length();

        String minPrefix;
        if (start <= curr) {
            minPrefix = "0";
        }
        else {
            if (startLength == s.length()) {
                minPrefix = "1";
            } else {
                String substring = startStr.substring(startLength - s.length());
                long l = Long.parseLong(substring);
                minPrefix = startStr.substring(0, startLength - s.length());
                char[] charArray = minPrefix.toCharArray();
                boolean minus = false;
                for (int i = 0; i < charArray.length; i++) {
                    if (charArray[i] - '0' > limit) {
                        int idx = i;
                        while (idx > 0 && charArray[idx] - '0' > limit) {
                            charArray[idx] = '0';
                            charArray[idx - 1]++;
                            idx--;
                        }
                        for (int j = i+1; j < charArray.length; j++) {
                            charArray[j] = '0';
                        }
                        if (idx < 0 || (idx == 0 && charArray[idx] - '0' > limit)) {
                            charArray[0] = '0';
                            minPrefix = "1" + new String(charArray);
                        } else {
                            minPrefix = new String(charArray);
                        }
                        minus = true;
                        break;
                    }
                }
                if (!minus) {
                    boolean needAdd = l > curr;
                    boolean carry = false;
                    for (int i = charArray.length-1; i >= 0; i--) {
                        if (needAdd || carry) {
                            if (charArray[i] - '0' == limit) {
                                charArray[i] = '0';
                                needAdd = false;
                                carry = true;
                            } else {
                                charArray[i]++;
                                needAdd = false;
                                carry = false;
                            }
                        }
                    }
                    if (carry) {
                        minPrefix = "1" + new String(charArray);
                    } else {
                        minPrefix = new String(charArray);
                    }
                }
            }
        }
        long i1 = Long.parseLong(minPrefix + s);
        if (i1 < start || i1 > finish) {
            return 0;
        }

        String maxPrefix;
        String substring = finishStr.substring(finishStr.length() - s.length());
        maxPrefix = finishStr.substring(0, finishLength - s.length());
        char[] charArray = maxPrefix.toCharArray();
        boolean minus = false;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] - '0' > limit) {
                charArray[i] = (char) ('0' + limit);
                for (int j = i+1; j < charArray.length; j++) {
                    charArray[j] = (char) ('0' + limit);
                }
                minus = true;
                break;
            }
        }
        if (!minus) {
            boolean carry = false;
            boolean needMinus = Long.parseLong(substring) < curr;
            for (int i = charArray.length-1; i >= 0; i--) {
                if (charArray[i] == '0') {
                    if (needMinus || carry) {
                        charArray[i] = (char) ('0' + limit);
                        needMinus = false;
                        carry = true;
                    }
                } else {
                    if (needMinus || carry) {
                        charArray[i]--;
                        needMinus = false;
                        carry = false;
                    }
                    if (charArray[i] - '0' > limit) {
                        charArray[i] = (char) ('0' + limit);
                    }
                }
            }
        }
        maxPrefix = new String(charArray);
        if (Long.parseLong(minPrefix) > Long.parseLong(maxPrefix)) {
            return 0;
        }
        // 计算 limit+1 进制下 maxPrefix - minPrefix
        long max = Long.parseLong(maxPrefix, limit + 1);
        long min = Long.parseLong(minPrefix, limit + 1);
        return max - min + 1;
    }

    public static void main(String[] args) {
        NumberOfPowerfulInt numberOfPowerfulInt = new NumberOfPowerfulInt();
        System.out.println(282254120 == numberOfPowerfulInt.numberOfPowerfulInt(
                1, 1000000000000000L, 5, "1000000000000000"));
        System.out.println(282254120 == numberOfPowerfulInt.numberOfPowerfulInt(
                7418894034L, 65017406794854L, 8, "28876"));
        System.out.println(34571999 == numberOfPowerfulInt.numberOfPowerfulInt(
                8385922281L, 56724293041189L, 6, "51662"));
        System.out.println(15646653 == numberOfPowerfulInt.numberOfPowerfulInt(
                6650981551L, 26414248319364L, 7, "43"));
        System.out.println(15646653 == numberOfPowerfulInt.numberOfPowerfulInt(
                163566007, 24775613339457L, 6, "30212"));
        System.out.println(16135677999L == numberOfPowerfulInt.numberOfPowerfulInt(
                697662853, 11109609599885L, 6, "5"));
        System.out.println(4194295 == numberOfPowerfulInt.numberOfPowerfulInt(
                123456, 32486458654L, 4, "1"));
        System.out.println(4194295 == numberOfPowerfulInt.numberOfPowerfulInt(
                1114, 1864854501, 7, "26"));
        System.out.println(5470 == numberOfPowerfulInt.numberOfPowerfulInt(
                1829505, 1255574165, 7, "32132"));
        System.out.println(5470 == numberOfPowerfulInt.numberOfPowerfulInt(
                1829505, 1255574165, 7, "11223"));
        System.out.println(162 == numberOfPowerfulInt.numberOfPowerfulInt(
                1, 2000, 8, "1"));
        System.out.println(0 == numberOfPowerfulInt.numberOfPowerfulInt(
                1300, 1400, 5, "245"));
        System.out.println(8 == numberOfPowerfulInt.numberOfPowerfulInt(
                20, 1159, 5, "20"));
        System.out.println(0 == numberOfPowerfulInt.numberOfPowerfulInt(
                141, 148, 9, "9"));
        System.out.println(5 == numberOfPowerfulInt.numberOfPowerfulInt(
                1, 6000, 4, "124"));
        System.out.println(2 == numberOfPowerfulInt.numberOfPowerfulInt(
                15, 215, 6, "10"));
        System.out.println(0 == numberOfPowerfulInt.numberOfPowerfulInt(
                1000, 2000, 4, "3000"));
    }
}
