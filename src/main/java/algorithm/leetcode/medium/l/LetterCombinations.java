package algorithm.leetcode.medium.l;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        if (length == 0) {
            return new ArrayList<>();
        }
        Character[][] c = new Character[4][4];
        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int aChar = Integer.parseInt(""+chars[i]);
            if (aChar < 7) {
                c[i][0] = (char) ((aChar - 2) * 3 + 97);
                c[i][1] = (char) ((aChar - 2) * 3 + 98);
                c[i][2] = (char) ((aChar - 2) * 3 + 99);
            } else if (aChar == 7){
                c[i][0] = (char) ((aChar - 2) * 3 + 97);
                c[i][1] = (char) ((aChar - 2) * 3 + 98);
                c[i][2] = (char) ((aChar - 2) * 3 + 99);
                c[i][3] = (char) ((aChar - 2) * 3 + 100);
            } else if (aChar == 8) {
                c[i][0] = 't';
                c[i][1] = 'u';
                c[i][2] = 'v';
            } else {
                c[i][0] = 'w';
                c[i][1] = 'x';
                c[i][2] = 'y';
                c[i][3] = 'z';
            }
        }

        List<String> resList = new ArrayList<>((int)Math.pow(3,length));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (c[0][i] != null) {
                sb.append(c[0][i]);
                for (int j = 0; j < 4; j++) {
                    if (c[1][j] != null) {
                        sb.append(c[1][j]);
                        for (int k = 0; k < 4; k++) {
                            if (c[2][k] != null) {
                                sb.append(c[2][k]);
                                for (int l = 0; l < 4; l++) {
                                    if (c[3][l] != null) {
                                        sb.append(c[3][l]);
                                        if (sb.length() == length) {
                                            resList.add(sb.toString());
                                        }
                                        sb.deleteCharAt(3);
                                    }
                                }
                                if (sb.length() == length) {
                                    resList.add(sb.toString());
                                }
                                sb.deleteCharAt(2);
                            }
                        }
                        if (sb.length() == length) {
                            resList.add(sb.toString());
                        }
                        sb.deleteCharAt(1);
                    }
                }
                if (sb.length() == length) {
                    resList.add(sb.toString());
                }
                sb = new StringBuilder();
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
        System.out.println(letterCombinations.letterCombinations(""));
        System.out.println(letterCombinations.letterCombinations("2"));
        System.out.println(letterCombinations.letterCombinations("7"));
    }
}
