package algorithm.leetcode.medium.m;

public class MaxChunksToSorted {

    // 题号 769 最多能完成排序的块 官解，贪心算法
    public int maxChunksToSorted(int[] arr) {
        int m = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                res++;
            }
        }
        return res;
    }

    public int maxChunksToSorted2(int[] arr) {
        int length = arr.length;
        int ans = 0;
        int start = -1;
        for (int i = 0; i < length; i++) {
            if (i != arr[i]) {
                start = i;
                break;
            } else {
                ans++;
            }
        }
        if (start == -1) {
            return length;
        }
        int currentChunkStartIndex = start;
        int currentChunkMaxIndex = arr[start];
        int currentChunkCount = 1;
        for (int i = start+1; i < length; i++) {
            if (arr[i] > currentChunkMaxIndex) {
                currentChunkMaxIndex = arr[i];
                currentChunkCount++;
            } else {
                currentChunkCount++;
                if (currentChunkCount == currentChunkMaxIndex-currentChunkStartIndex+1) {
                    ans++;
                    while (i < length-1) {
                        if (i+1 != arr[i+1]) {
                            break;
                        }
                        ans++;
                        i++;
                    }
                    if (i < length-1) {
                        currentChunkStartIndex = i+1;
                        currentChunkMaxIndex = arr[i+1];
                        currentChunkCount = 1;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxChunksToSorted maxChunksToSorted = new MaxChunksToSorted();
        System.out.println(4 == maxChunksToSorted.maxChunksToSorted(new int[]{0,1,2,4,3}));
        System.out.println(5 == maxChunksToSorted.maxChunksToSorted(new int[]{0,1,2,3,4}));
        System.out.println(4 == maxChunksToSorted.maxChunksToSorted(new int[]{1,0,2,3,4}));
        System.out.println(1 == maxChunksToSorted.maxChunksToSorted(new int[]{4,3,2,1,0}));
    }
}
