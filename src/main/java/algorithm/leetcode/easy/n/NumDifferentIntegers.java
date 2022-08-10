package algorithm.leetcode.easy.n;

import java.util.HashSet;
import java.util.Set;

public class NumDifferentIntegers {

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(word.charAt(i))) {
                if (i == length-1) {
                    set.add(word.substring(i));
                } else {
                    if (!Character.isDigit(word.charAt(i+1))) {
                        set.add(word.substring(i,i+1));
                    } else if (word.charAt(i) != '0') {
                        for (int j = i; j < length; j++) {
                            if (!Character.isDigit(word.charAt(j))) {
                                set.add(word.substring(i,j));
                                i = j;
                                break;
                            }
                            if (j == length-1) {
                                set.add(word.substring(i,j+1));
                                i = j;
                            }
                        }
                    }
                }
            }
        }
        return set.size();
    }

    // 时间复杂度不合格
    public int numDifferentIntegers2(String word) {
        for (char i = 'a'; i <= 'z'; i++) {
            word = word.replaceAll(i+""," ");
        }
        Set<String> set = new HashSet<>();
        String[] s = word.split(" ");
        for (String s1 : s) {
            s1 = s1.trim();
            if (!"".equals(s1)) {
                while (s1.length() > 1 && s1.startsWith("0")) {
                    s1 = s1.substring(1);
                }
                set.add(s1);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        NumDifferentIntegers numDifferentIntegers = new NumDifferentIntegers();
        System.out.println(numDifferentIntegers.numDifferentIntegers("a123bc34d8ef34"));
    }

}
