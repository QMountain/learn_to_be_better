package algorithm.leetcode.hard;

public class Trap {

    public int trap(int[] height) {
        int mid = 0;
        int length = height.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            int h = height[i];
            // left
            if (h > 0) {
                mid = i+1;
                for (int j = i+1; j < length; j++) {
                    int hj = height[j];
                    if (hj >= height[i]) {
                        break;
                    }
                    if (hj < height[mid]) {
                        if (hj < height[mid]) {
                            mid = j;
                        }
                    }
                    if (j == length-1) {
                        break;
                    }
                    if (height[j+1] > hj) {
                        for (int k = j+1; k < length; k++) {
                            if (k == length-1) {
                                if (height[k] >= height[i]) {
                                    int standard = Math.min(height[i],height[k]);
                                    for (int l = i+1; l < k; l++) {
                                        res += standard-height[l];
                                    }
                                    j = length-1;
                                    i = k-1;
                                    break;
                                } else {
                                    int right = mid+1;
                                    for (int l = mid+1; l < length; l++) {
                                        if (height[l] > height[right]) {
                                            right = l;
                                        }
                                    }
                                    if (height[right] > height[mid]) {
                                        int standard = Math.min(height[i],height[right]);
                                        for (int l = i+1; l <= right; l++) {
                                            if (standard > height[l]) {
                                                res += standard-height[l];
                                            }
                                        }
                                        j = length-1;
                                        i = right-1;
                                        break;
                                    }
                                }
                            }
                            if (height[k] >= height[i]) {
                                int standard = Math.min(height[i],height[k]);
                                for (int l = i+1; l < k; l++) {
                                    res += standard-height[l];
                                }
                                j = length-1;
                                i = k-1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap(new int[]{5,4,1,2}));
        System.out.println(trap.trap(new int[]{4,2,3}));
        System.out.println(trap.trap(new int[]{4,2,0,3,2,5}));

        System.out.println(trap.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

    }
}
