package algorithm.leetcode.hard.l;

import java.util.HashSet;
import java.util.Set;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int largest = 0;
        for (int i = 0; i < length; i++) {
            if (heights[i] > 0) {
                int firstZeroIndex = -1;
                for (int j = i+1; j < length; j++) {
                    if (heights[j] == 0) {
                        firstZeroIndex = j;
                        break;
                    }
                }
                if (firstZeroIndex == -1) {
                    int area = getBetweenIndex(heights, i, length-1);
                    largest = Math.max(largest,area);
                    break;
                } else {
                    int area = getBetweenIndex(heights, i, firstZeroIndex - 1);
                    largest = Math.max(largest,area);
                    i = firstZeroIndex;
                }
            }
        }
        return largest;
    }

    public int getBetweenIndex(int[] heights, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return heights[startIndex];
        }
        int largest = heights[startIndex];
        Set<Integer> possibleHeight = new HashSet<>();
        for (int i = startIndex; i <= endIndex; i++) {
            possibleHeight.add(heights[i]);
        }
        for (Integer height : possibleHeight) {
            int maxLength = 1;
            for (int j = startIndex; j <= endIndex; j++) {
                if (heights[j] >= height) {
                    int firstSmallerIndex = -1;
                    for (int k = j+1; k <= endIndex; k++) {
                        if (heights[k] < height) {
                            firstSmallerIndex = k;
                            break;
                        }
                    }
                    if (firstSmallerIndex == -1) {
                        maxLength = Math.max(endIndex-j+1,maxLength);
                        break;
                    } else {
                        maxLength = Math.max(firstSmallerIndex-j,maxLength);
                        j = firstSmallerIndex;
                    }
                }
            }
            largest = Math.max(height*maxLength,largest);
        }
        return largest;
    }

    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{4,2}));
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
