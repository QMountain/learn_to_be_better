package algorithm.leetcode.medium.p;

public class PushDominoes {

    /**
     * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
     * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
     * 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
     * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
     * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
     * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
     * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
     * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
     * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
     * 返回表示最终状态的字符串。
     * n == dominoes.length
     * 1 <= n <= 10^5
     * dominoes[i] 为 'L'、'R' 或 '.'
     */
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        char start = '0';
        int startIndex = 0;
        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (start == '0') {
                if (c == 'L') {
                    sb.append(c);
                } else {
                    start = c;
                    startIndex = i;
                }
                continue;
            }
            if (c == 'L') {
                if (start == '.') {
                    for (int j = startIndex; j <= i; j++) {
                        sb.append("L");
                    }
                } else {
                    if ((i - startIndex) % 2 == 0) {
                        int len = (i - startIndex) / 2;
                        for (int j = 0; j < len; j++) {
                            sb.append("R");
                        }
                        sb.append(".");
                        for (int j = 0; j < len; j++) {
                            sb.append("L");
                        }
                    } else {
                        int len = (i - startIndex + 1) / 2;
                        for (int j = 0; j < len; j++) {
                            sb.append("R");
                        }
                        for (int j = 0; j < len; j++) {
                            sb.append("L");
                        }
                    }
                }
                start = '0';
            } else if (c == 'R') {
                // c == 'R'
                if (start == '.') {
                    for (int j = startIndex; j < i; j++) {
                        sb.append(".");
                    }
                    start = 'R';
                } else {
                    for (int j = startIndex; j < i; j++) {
                        sb.append('R');
                    }
                }
                startIndex = i;
            }
        }
        if (start != '0') {
            for (int j = startIndex; j < dominoes.length(); j++) {
                 sb.append(start);
             }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PushDominoes pushDominoes = new PushDominoes();
        System.out.println("LL".equals(pushDominoes.pushDominoes("LL")));
        System.out.println("LL.RR".equals(pushDominoes.pushDominoes(".L.R.")));
        System.out.println("RR.L".equals(pushDominoes.pushDominoes("RR.L")));
        System.out.println("LL.RR.LLRRLL..".equals(pushDominoes.pushDominoes(".L.R...LR..L..")));
    }
}
