package algorithm.leetcode.medium.f;

import java.util.Arrays;

public class FindLongestSubarray {

    // 第一遍尝试 O(n^2) 5%
    public String[] findLongestSubarray2(String[] array) {
        int length = array.length;
        int countChar = 0;
        int[] countLeftCharArr = new int[length];
        for (int i = 0; i < length; i++) {
            char c = array[i].charAt(0);
            if (!Character.isDigit(c)) {
                countLeftCharArr[i] = countChar++;
            } else {
                countLeftCharArr[i] = countChar;
            }
        }
        int totalChar = countChar;
        countChar = 0;
        int[] countRightCharArr = new int[length];
        for (int i = length-1; i >= 0; i--) {
            char c = array[i].charAt(0);
            if (!Character.isDigit(c)) {
                countRightCharArr[i] = countChar++;
            } else {
                countRightCharArr[i] = countChar;
            }
        }
        int startIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length-1; j >= i; j--) {
                int currLength = j - i + 1;
                if (currLength <= maxLength) {
                    break;
                }
                int middleCharCount = totalChar - countLeftCharArr[i] - countRightCharArr[j];
                if (middleCharCount << 1 == currLength) {
                    maxLength = currLength;
                    startIndex = i;
                }
            }
        }
        String[] ans = new String[maxLength];
        int p = 0;
        for (int i = startIndex; i < startIndex+maxLength; i++) {
            ans[p++] = array[i];
        }
        return ans;
    }

    // 第二次尝试，还是O(n^2) 5% 没啥大提升
    public String[] findLongestSubarray(String[] array) {
        int length = array.length;
        int countChar = 0;
        int[] countLeftCharArr = new int[length];
        for (int i = 0; i < length; i++) {
            char c = array[i].charAt(0);
            if (!Character.isDigit(c)) {
                countLeftCharArr[i] = countChar++;
            } else {
                countLeftCharArr[i] = countChar;
            }
        }
        int totalChar = countChar;
        int totalNum = length - totalChar;
        int diff = Math.abs(totalNum - totalChar);
        if (diff == 0) {
            return array;
        }
        if (diff == length) {
            return new String[0];
        }
        countChar = 0;
        int[] countRightCharArr = new int[length];
        for (int i = length-1; i >= 0; i--) {
            char c = array[i].charAt(0);
            if (!Character.isDigit(c)) {
                countRightCharArr[i] = countChar++;
            } else {
                countRightCharArr[i] = countChar;
            }
        }
        // i 为 cut 总数
        for (int i = diff; i <= length; i+=2) {
            // j 为 从左侧 cut 的数量
            for (int j = 0; j <= i; j++) {
                int middleCharCount = totalChar - countLeftCharArr[j] - countRightCharArr[length-i+j-1];
                int currLength = length - i;
                if (middleCharCount << 1 == currLength) {
                    String[] ans = new String[currLength];
                    System.arraycopy(array, j, ans, 0, currLength);
                    return ans;
                }
            }
        }
        return new String[0];
    }

    public static void main(String[] args) {
        FindLongestSubarray findLongestSubarray = new FindLongestSubarray();
        System.out.println(Arrays.toString(findLongestSubarray.findLongestSubarray(new String[]{"42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5","S","Z","D","2","A","W","k","84","44","96","96","y","M"})));
        System.out.println(Arrays.toString(findLongestSubarray.findLongestSubarray(new String[]{"A","A"})));
        System.out.println(Arrays.toString(findLongestSubarray.findLongestSubarray(
                new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"})));
    }
}
