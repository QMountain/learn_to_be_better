package algorithm.leetcode.medium.o;

public class OriginalDigits {

    String[] numStr = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
    char[] specialChar = new char[]{'z','o','w','h','u','f','x','v','g','i'};
    int[] cutOrder = new int[]{0,2,4,6,8,1,3,5,7};
    int[] arr;
    int[] count;

    public String originalDigits(String s) {
        this.arr = new int[10];
        this.count = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            count[s.charAt(i)-'a']++;
        }
        cut();
        arr[9] = count['i'-'a'];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int times = arr[i];
            for (int j = 0; j < times; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public void cut() {
        for (int cutNum : cutOrder) {
            String cutNumStr = numStr[cutNum];
            char sc = specialChar[cutNum];
            int length = cutNumStr.length();
            int countSc = count[sc - 'a'];
            if (countSc > 0) {
                arr[cutNum] = countSc;
                for (int i = 0; i < length; i++) {
                    char c = cutNumStr.charAt(i);
                    count[c-'a'] -= countSc;
                }
            }
        }
    }

    public static void main(String[] args) {
        OriginalDigits originalDigits = new OriginalDigits();
        System.out.println("45".equals(originalDigits.originalDigits("fviefuro")));
        System.out.println("012".equals(originalDigits.originalDigits("owoztneoer")));
    }
}
