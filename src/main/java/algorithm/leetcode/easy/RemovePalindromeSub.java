package algorithm.leetcode.easy;

/**
 * @ClassName RemovePalindromeSub
 * @Description
 * @Author qsf
 * Date   2022-01-22  22:52
 */
public class RemovePalindromeSub {

    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int leftIndex = 0;
        int rightIndex = s.length()-1;
        boolean evenNumber = s.length() % 2 == 0;
        boolean subStringEvenNumber = true;
        while (evenNumber ? leftIndex <= s.length()/2-1 : leftIndex <= (s.length()+1)/2-1) {
            // find first end from end
            for (int i = s.length()-1-leftIndex; i >= leftIndex; i--) {
                if (s.charAt(i) == s.charAt(leftIndex) && s.length()-i == leftIndex){
                    rightIndex = i;
                    if (i == leftIndex) {
                        subStringEvenNumber = false;
                    }
                    break;
                }
            }
            if (rightIndex > 0 && leftIndex+1 <= (evenNumber ? s.length()/2-1 : (s.length()+1)/2-1)) {
                leftIndex++;
            } else {
                break;
            }
        }
        if (subStringEvenNumber) {
            s = s.substring(leftIndex * 2+2);
        } else {
            s = s.substring(leftIndex*2+1);
        }

        return removePalindromeSub(s) + 1;
    }

    public static void main(String[] args) {
        RemovePalindromeSub sub = new RemovePalindromeSub();
        /*// 1
        System.out.println(sub.removePalindromeSub("ababa"));
        // 2
        System.out.println(sub.removePalindromeSub("abb"));*/
        // 2
        System.out.println(sub.removePalindromeSub("baabb"));
    }

}
