package algorithm.leetcode.easy.c;

public class CountPoints {

    public int countPoints(String rings) {
        // 111
        // 7 三色已全，4 红色，2 绿色，1 蓝色
        int[] arr = new int[10];
        int ans = 0;
        int length = rings.length();
        for (int i = 0; i < length; i+=2) {
            int index = rings.charAt(i+1) - '0';
            if (arr[index] == 7) {
                continue;
            }
            char c = rings.charAt(i);
            if (c == 'R' && (arr[index] & 4) == 0) {
                arr[index] |= 4;
            } else if (c == 'G' && (arr[index] & 2) == 0) {
                arr[index] |= 2;
            } else if (c == 'B' && (arr[index] & 1) == 0) {
                arr[index] |= 1;
            }
            if (arr[index] == 7) {
                ans++;
            }
            if (ans == 10) {
                return 10;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountPoints countPoints = new CountPoints();
        System.out.println(countPoints.countPoints("B5B9R8B9R7B9B6R8B3R1R7G5G8B7B9B9B7B4R8R5"));
        System.out.println(countPoints.countPoints("B0R0G0R9R0B0G0"));
        System.out.println(countPoints.countPoints("B0B6G0R6R0R6G9"));
    }

}
