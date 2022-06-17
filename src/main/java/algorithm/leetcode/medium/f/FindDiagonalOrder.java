package algorithm.leetcode.medium.f;

import java.util.Arrays;

public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] ansArr = new int[rows*cols];
        goNext(mat,0,0,0,ansArr,0);
        return ansArr;
    }

    public void goNext(int[][] mat, int startRow, int startCol, int towards,
                       int[] ansArr, int putIndex) {
        ansArr[putIndex++] = mat[startRow][startCol];
        if (startRow == mat.length-1 && startCol == mat[0].length-1) {
            return;
        }
        if (towards == 0) {
            while (startRow > 0 && startCol < mat[0].length-1) {
                ansArr[putIndex++] = mat[--startRow][++startCol];
            }
            if (startCol < mat[0].length-1) {
                goNext(mat,startRow,startCol+1,1,ansArr,putIndex);
            } else {
                goNext(mat,startRow+1,startCol,1,ansArr,putIndex);
            }
        } else {
            while (startRow < mat.length-1 && startCol > 0) {
                ansArr[putIndex++] = mat[++startRow][--startCol];
            }
            if (startRow < mat.length-1) {
                goNext(mat,startRow+1,startCol,0,ansArr,putIndex);
            } else {
                goNext(mat,startRow,startCol+1,0,ansArr,putIndex);
            }
        }
    }

    public static void main(String[] args) {
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        System.out.println(Arrays.toString(findDiagonalOrder.findDiagonalOrder(new int[][]{{2,5,8},{4,0,-1}})));
        System.out.println(Arrays.toString(findDiagonalOrder.findDiagonalOrder(new int[][]{{1,2},{3,4}})));
        System.out.println(Arrays.toString(findDiagonalOrder.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
    }
}
