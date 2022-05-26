package algorithm.leetcode.medium.s;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows-1][cols-1]) {
            return false;
        }
        return searchMatrix(matrix,target,0,0,rows-1,cols-1);
    }

    public boolean searchMatrix(int[][] matrix, int target, int leftRow, int leftCol, int rightRow, int rightCol) {
        while (leftRow <= rightRow && leftCol <= rightCol) {
            int midRow = (leftRow+rightRow)/2;
            int midCol = (leftCol+rightCol)/2;
            if (target == matrix[midRow][midCol]) {
                return true;
            }
            if (target < matrix[midRow][midCol]) {
                if (midRow == rightRow && midCol == rightCol) {
                    break;
                }
                if (midRow > leftRow) {
                    boolean leftDown = searchMatrix(matrix, target, midRow, leftCol, rightRow, midCol - 1);
                    if (leftDown) {
                        return true;
                    }
                    boolean rightUp = searchMatrix(matrix, target, leftRow, midCol, midRow - 1, rightCol);
                    if (rightUp) {
                        return true;
                    }
                }
                rightRow = midRow;
                rightCol = midCol;
            } else {
                if (midRow == leftRow && midCol == leftCol) {
                    break;
                }
                if (midRow > leftRow) {
                    boolean leftDown = searchMatrix(matrix, target, midRow + 1, leftCol, rightRow, midCol);
                    if (leftDown) {
                        return true;
                    }
                    boolean rightUp = searchMatrix(matrix, target, leftRow, midCol + 1, midRow, rightCol);
                    if (rightUp) {
                        return true;
                    }
                }

                leftRow = midRow;
                leftCol = midCol;
            }
        }
        for (int i = leftCol; i <= rightCol; i++) {
            if (matrix[leftRow][i] == target) {
                return true;
            }
            if (matrix[rightRow][i] == target) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(new int[][]{{5,6,10,14},{6,10,13,18},{10,13,18,19}}, 14));
        System.out.println(searchMatrix.searchMatrix(new int[][]{{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}}, 11));
        System.out.println(!searchMatrix.searchMatrix(new int[][]{{1,3,5}}, 4));
        System.out.println(searchMatrix.searchMatrix(new int[][]{{1,3,5}}, 1));
        System.out.println(searchMatrix.searchMatrix(new int[][]{{5,6,10,14},{6,10,13,18},{10,13,18,19}}, 14));
        System.out.println(searchMatrix.searchMatrix(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}, 15));
        System.out.println(searchMatrix.searchMatrix(new int[][]{{-1,3}}, 3));
        System.out.println(searchMatrix.searchMatrix(new int[][]{{1,1}}, 1));
        System.out.println(searchMatrix.searchMatrix(new int[][]{{-5}}, -5));
        System.out.println(searchMatrix.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        System.out.println(searchMatrix.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
    }
}
