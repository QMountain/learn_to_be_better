package algorithm.leetcode.medium.c;

public class ComputeArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int h1 = Math.abs(ay1 - ay2);
        int w1 = Math.abs(ax1 - ax2);
        int h2 = Math.abs(by1 - by2);
        int w2 = Math.abs(bx1 - bx2);
        int cover;
        if (bx2 <= ax1 || ax2 <= bx1 || by2 <= ay1 || ay2 <= by1) {
            cover = 0;
        } else {
            int coverW;
            int coverH;
            if (bx1 < ax1) {
                if (bx2 <= ax2) {
                    coverW = bx2 - ax1;
                } else {
                    coverW = ax2 - ax1;
                }
            } else {
                if (bx2 <= ax2) {
                    coverW = bx2 - bx1;
                } else {
                    coverW = ax2 - bx1;
                }
            }
            if (by1 < ay1) {
                if (by2 <= ay2) {
                    coverH = by2 - ay1;
                } else {
                    coverH = ay2 - ay1;
                }
            } else {
                if (by2 <= ay2) {
                    coverH = by2 - by1;
                } else {
                    coverH  = ay2 - by1;
                }
            }
            cover = coverH * coverW;
        }
        return h1 * w1 + h2 * w2 - cover;
    }

    public static void main(String[] args) {
        ComputeArea computeArea = new ComputeArea();
        System.out.println(computeArea.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        System.out.println(computeArea.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
