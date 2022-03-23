package algorithm.leetcode.medium;

public class WinnerOfGame {

    public boolean winnerOfGame(String colors) {
        int length = colors.length();
        if (length < 3) {
            return false;
        }
        int cutA = 0;
        int cutB = 0;
        for (int i = 0; i < length; i++) {
            if (colors.charAt(i) == 'A') {
                int end = length-1;
                for (int j = i+1; j < length; j++) {
                    if (colors.charAt(j) == 'B') {
                        end = j-1;
                        break;
                    }
                }
                if (end - i+1 >= 3) {
                    cutA += end - i-1;
                }
                i = end;
            }
        }
        for (int i = 0; i < length; i++) {
            if (colors.charAt(i) == 'B') {
                int end = length-1;
                for (int j = i+1; j < length; j++) {
                    if (colors.charAt(j) == 'A') {
                        end = j-1;
                        break;
                    }
                }
                if (end - i+1 >= 3) {
                    cutB += end - i-1;
                }
                i = end;
            }
        }
        return cutA > cutB;
    }

    public boolean prefer(String colors, boolean prefer) {
        int length = colors.length();
        if (length < 3) {
            return !prefer;
        }
        for (int i = 1; i < length - 1; i++) {
            if ((colors.charAt(i) == (prefer ? 'A' : 'B'))
                    && colors.charAt(i) == colors.charAt(i-1)
                    && colors.charAt(i) == colors.charAt(i+1)) {
                String s = colors.substring(0,i)+colors.substring(i+1,length);
                if (prefer(s,!prefer) == prefer) {
                    return prefer;
                }
            }
        }
        return !prefer;
    }

    public static void main(String[] args) {
        WinnerOfGame winnerOfGame = new WinnerOfGame();
        System.out.println(!winnerOfGame.winnerOfGame("AAAABBBB"));
        System.out.println(winnerOfGame.winnerOfGame("AAABABB"));
        System.out.println(!winnerOfGame.winnerOfGame("AA"));
        System.out.println(!winnerOfGame.winnerOfGame("ABBBBBBBAAA"));
    }
}
