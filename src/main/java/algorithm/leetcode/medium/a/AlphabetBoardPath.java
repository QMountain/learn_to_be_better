package algorithm.leetcode.medium.a;

public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        char last = 'a';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c == last) {
                sb.append("!");
                continue;
            }
            boolean t = false;
            if (c == 'z') {
                t = true;
                c = 'u';
            }
            int lastDiff = last - 'a';
            int lastX = lastDiff / 5;
            int lastY = lastDiff % 5;
            int diff = c - 'a';
            int x = diff / 5;
            int y = diff % 5;
            if (lastX < x) {
                for (int j = 0; j < x-lastX; j++) {
                    sb.append("D");
                }
            } else {
                for (int j = 0; j < lastX - x; j++) {
                    sb.append("U");
                }
            }
            if (lastY < y) {
                for (int j = 0; j < y - lastY; j++) {
                    sb.append("R");
                }
            } else {
                for (int j = 0; j < lastY - y; j++) {
                    sb.append("L");
                }
            }
            if (t) {
                sb.append("D");
                c = 'z';
            }
            sb.append("!");
            last = c;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AlphabetBoardPath alphabetBoardPath = new AlphabetBoardPath();
        System.out.println(alphabetBoardPath.alphabetBoardPath("zz"));
        System.out.println(alphabetBoardPath.alphabetBoardPath("zdz"));
        System.out.println(alphabetBoardPath.alphabetBoardPath("code"));
        System.out.println(alphabetBoardPath.alphabetBoardPath("leet"));
    }
}
