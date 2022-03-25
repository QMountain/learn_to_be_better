package algorithm.leetcode.easy;

import java.util.Arrays;

public class ImageSmoother {

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        if (m == 1 && n == 1) {
            return img;
        }
        int[][] resArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    if (m > 1 && n > 1) {
                        resArr[i][j] = (img[i][j] +
                                img[i][j+1] +
                                img[i+1][j] +
                                img[i+1][j+1]) / 4;
                    } else if (m > 1) {
                        resArr[i][j] = (img[i][j] +
                                img[i+1][j]) / 2;
                    } else {
                        resArr[i][j] = (img[i][j] +
                                img[i][j+1]) / 2;
                    }
                } else if (i == 0 && j == n-1) {
                    if (m > 1) {
                        resArr[i][j] = (img[i][j-1] +
                                img[i][j] +
                                img[i+1][j-1] +
                                img[i+1][j]) / 4;
                    } else {
                        resArr[i][j] = (img[i][j-1] +
                                img[i][j]) / 2;
                    }
                } else if (i == m-1 && j == 0) {
                    if (n > 1) {
                        resArr[i][j] = (img[i-1][j] +
                                img[i-1][j+1] +
                                img[i][j] +
                                img[i][j+1]) / 4;
                    } else {
                        resArr[i][j] = (img[i-1][j] +
                                img[i][j]) / 2;
                    }
                } else if (i == m-1 && j == n-1) {
                    resArr[i][j] = (img[i-1][j-1] +
                            img[i-1][j] +
                            img[i][j-1] +
                            img[i][j]) / 4;
                } else if (i == 0) {
                    if (m > 1) {
                        resArr[i][j] = (img[i][j-1] +
                                img[i][j] +
                                img[i][j+1] +
                                img[i+1][j-1] +
                                img[i+1][j] +
                                img[i+1][j+1]) / 6;
                    } else {
                        resArr[i][j] = (img[i][j-1] +
                                img[i][j] +
                                img[i][j+1]) / 3;
                    }
                } else if (i == m-1) {
                    resArr[i][j] = (img[i-1][j-1] +
                            img[i-1][j] +
                            img[i-1][j+1] +
                            img[i][j-1] +
                            img[i][j] +
                            img[i][j+1]) / 6;
                } else if (j == 0) {
                    if (n > 1) {
                        resArr[i][j] = (img[i-1][j] +
                                img[i-1][j+1] +
                                img[i][j] +
                                img[i][j+1] +
                                img[i+1][j] +
                                img[i+1][j+1]) / 6;
                    } else {
                        resArr[i][j] = (img[i-1][j] +
                                img[i][j] +
                                img[i+1][j]) / 3;
                    }
                } else if (j == n-1) {
                    resArr[i][j] = (img[i-1][j-1] +
                            img[i-1][j] +
                            img[i][j-1] +
                            img[i][j] +
                            img[i+1][j-1] +
                            img[i+1][j]) / 6;
                } else {
                    resArr[i][j] = (img[i-1][j-1] +
                            img[i-1][j] +
                            img[i-1][j+1] +
                            img[i][j-1] +
                            img[i][j] +
                            img[i][j+1] +
                            img[i+1][j-1] +
                            img[i+1][j] +
                            img[i+1][j+1]) / 9;
                }
            }
        }
        return resArr;
    }

    public static void main(String[] args) {
        ImageSmoother imageSmoother = new ImageSmoother();
        System.out.println(Arrays.deepToString(
                imageSmoother.imageSmoother(new int[][]{{6,9,7}})));
        System.out.println(Arrays.deepToString(
                imageSmoother.imageSmoother(new int[][]{{6},{9},{7}})));
        System.out.println(Arrays.deepToString(
                imageSmoother.imageSmoother(new int[][]{{3},{2}})));
        System.out.println(Arrays.deepToString(
                imageSmoother.imageSmoother(new int[][]{{1}})));
        System.out.println(Arrays.deepToString(
                imageSmoother.imageSmoother(new int[][]{{2,3}})));
        System.out.println(Arrays.deepToString(
                imageSmoother.imageSmoother(new int[][]{{1,1,1},{1,0,1},{1,1,1}})));
        System.out.println(Arrays.deepToString(
                imageSmoother.imageSmoother(new int[][]{{100,200,100},{200,50,200},{100,200,100}})));

    }
}
