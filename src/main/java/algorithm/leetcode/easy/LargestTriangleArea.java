package algorithm.leetcode.easy;

public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        int length = points.length;
        double max = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i+1; j < length - 1; j++) {
                for (int k = j+1; k < length; k++) {
                    max = Math.max(max,calculateArea(points[i],points[j],points[k]));
                }
            }
        }
        return max;
    }

    // 鞋带公式
    public double calculateArea(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }

    public static void main(String[] args) {
        LargestTriangleArea largestTriangleArea = new LargestTriangleArea();
        System.out.println(largestTriangleArea.largestTriangleArea(
                new int[][]{{2,5},{7,7},{10,8},{10,10},{1,1}}));
    }
}
