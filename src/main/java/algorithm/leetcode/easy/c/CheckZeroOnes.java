package algorithm.leetcode.easy.c;

public class CheckZeroOnes {

    public boolean checkZeroOnes(String s) {
        int length = s.length();
        int maxOne = 0;
        int maxZero = 0;
        for (int i = 0; i < length; i++) {
            int count = 0;
            if (s.charAt(i) == '1') {
                for (int j = i; j < length; j++) {
                    if (s.charAt(j) == '1') {
                        count++;
                    } else {
                        i = j-1;
                        break;
                    }
                }
                maxOne = Math.max(maxOne,count);
            } else {
                for (int j = i; j < length; j++) {
                    if (s.charAt(j) == '0') {
                        count++;
                    } else {
                        i = j-1;
                        break;
                    }
                }
                maxZero = Math.max(maxZero,count);
            }
        }
        return maxOne > maxZero;
    }

    public static void main(String[] args) {
        CheckZeroOnes checkZeroOnes = new CheckZeroOnes();
        System.out.println(checkZeroOnes.checkZeroOnes("110100010"));
        System.out.println(checkZeroOnes.checkZeroOnes("111000"));
        System.out.println(checkZeroOnes.checkZeroOnes("1101"));
    }
}
