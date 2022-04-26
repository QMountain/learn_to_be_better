package algorithm.leetcode.medium.r;

import java.util.Arrays;

public class Rotate {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int i = 0;
        int j = 0;
        while (length > 0) {
            int[] array = getArray(matrix, i, j, length);
            int index = 0;
            for (int k = i; k < j + length - 1; k++) {
                matrix[i][k] = array[index];
                index++;
            }
            for (int k = i; k < i + length - 1; k++) {
                 matrix[k][j+length-1] = array[index];
                index++;
            }
            for (int k = j+length-1; k > j; k--) {
                matrix[i+length-1][k] = array[index];
                index++;
            }
            for (int k = i+length-1; k > i; k--) {
                matrix[k][j] = array[index];
                index++;
            }
            length -= 2;
            i++;
            j++;
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public int[] getArray(int[][] matrix, int i,int j,int length) {
        int[] arr = new int[length*4-4];
        int index = 0;
        for (int k = j; k < j + length-1; k++) {
            arr[index] = matrix[i][k];
            index++;
        }
        for (int k = i; k < i + length - 1; k++) {
            arr[index] = matrix[k][j+length-1];
            index++;
        }
        for (int k = j+length-1; k > j; k--) {
            arr[index] = matrix[i+length-1][k];
            index++;
        }
        for (int k = i+length-1; k > i; k--) {
            arr[index] = matrix[k][j];
            index++;
        }
        int[] movedArr = new int[length*4-4];
        System.arraycopy(arr,0,movedArr,length-1,(length-1)*3);
        System.arraycopy(arr,(length-1)*3,movedArr,0,length-1);
        return movedArr;
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        rotate.rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
        rotate.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
