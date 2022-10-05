package algorithm.leetcode.hard.t;

import java.util.Arrays;

public class ThreeEqualParts {

    public int[] threeEqualParts(int[] arr) {
        int totalOne = 0;
        for (int i : arr) {
            if (i == 1) {
                totalOne++;
            }
        }
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if (totalOne % 3 != 0) {
            return ans;
        }
        if (totalOne == 0) {
            ans[0] = 0;
            ans[1] = 2;
            return ans;
        }
        int eachPartOneCount = totalOne / 3;
        int firstPartRightOneIndex = -1;
        int secondPartLeftOneIndex = -1;
        int secondPartRightOneIndex = -1;
        int thirdPartLeftOneIndex = -1;
        int thirdPartRightOneIndex = -1;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();
        int length = arr.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 1) {
                count++;
                if (count == eachPartOneCount) {
                    firstPartRightOneIndex = i;
                }
                if (count == eachPartOneCount+1) {
                    secondPartLeftOneIndex = i;
                }
                if (count == eachPartOneCount*2) {
                    secondPartRightOneIndex = i;
                }
                if (count == eachPartOneCount*2+1) {
                    thirdPartLeftOneIndex = i;
                }
                if (count == totalOne) {
                    thirdPartRightOneIndex = i;
                }
            }
            if (count >= 1) {
                if (arr[i] == 1 && count <= eachPartOneCount) {
                    s1.append(arr[i]);
                } else if (arr[i] == 0 && count < eachPartOneCount) {
                    s1.append(arr[i]);
                }
            }
            if (count > eachPartOneCount) {
                if (arr[i] == 1 && count <= eachPartOneCount*2) {
                    s2.append(arr[i]);
                } else if (arr[i] == 0 && count < eachPartOneCount*2) {
                    s2.append(arr[i]);
                }
            }
            if (count > eachPartOneCount*2) {
                if (arr[i] == 1 && count <= eachPartOneCount*3) {
                    s3.append(arr[i]);
                } else if (arr[i] == 0 && count < eachPartOneCount*3) {
                    s3.append(arr[i]);
                }
            }
            if (count == totalOne) {
                break;
            }
        }
        if (!s1.toString().equals(s2.toString())) {
            return ans;
        }
        if (!s1.toString().equals(s3.toString())) {
            return ans;
        }
        int thirdPartEndZeroCount = length-1 - thirdPartRightOneIndex;
        int secondThirdPartZeroMax = thirdPartLeftOneIndex - secondPartRightOneIndex - 1;
        if (secondThirdPartZeroMax < thirdPartEndZeroCount) {
            return ans;
        }
        int firstSecondPartZeroMax = secondPartLeftOneIndex - firstPartRightOneIndex - 1;
        if (firstSecondPartZeroMax < thirdPartEndZeroCount) {
            return ans;
        }
        ans[0] = firstPartRightOneIndex + thirdPartEndZeroCount;
        ans[1] = secondPartRightOneIndex + thirdPartEndZeroCount+1;
        return ans;
    }

    public static void main(String[] args) {
        ThreeEqualParts threeEqualParts = new ThreeEqualParts();
        System.out.println(Arrays.toString(threeEqualParts.threeEqualParts(new int[]{1,1,0,0,1})));
        System.out.println(Arrays.toString(threeEqualParts.threeEqualParts(new int[]{1,1,0,1,1})));
        System.out.println(Arrays.toString(threeEqualParts.threeEqualParts(new int[]{1, 0, 1, 0, 1})));
    }
}
