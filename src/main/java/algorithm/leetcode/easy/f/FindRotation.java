package algorithm.leetcode.easy.f;

public class FindRotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        StringBuilder sb0 = new StringBuilder();
        for (int[] ints : mat) {
            for (int anInt : ints) {
                sb0.append(",");
                sb0.append(anInt);
            }
        }
        StringBuilder sb90 = new StringBuilder();
        int length = mat.length;
        for (int i = 0; i < length; i++) {
            for (int j = length-1; j >= 0; j--) {
                sb90.append(",");
                sb90.append(mat[j][i]);
            }
        }
        StringBuilder sb180 = new StringBuilder();
        for (int i = length-1; i >= 0; i--) {
            for (int j = length-1; j >= 0; j--) {
                sb180.append(",");
                sb180.append(mat[i][j]);
            }
        }
        StringBuilder sb270 = new StringBuilder();
        for (int i = length-1; i >= 0; i--) {
            for (int j = 0; j < length; j++) {
                sb270.append(",");
                sb270.append(mat[j][i]);
            }
        }
        StringBuilder sbt = new StringBuilder();
        for (int[] ints : target) {
            for (int anInt : ints) {
                sbt.append(",");
                sbt.append(anInt);
            }
        }
        String st = sbt.toString();
        return st.equals(sb0.toString()) || st.equals(sb90.toString()) || st.equals(sb180.toString()) || st.equals(sb270.toString());
    }

    public static void main(String[] args) {
        FindRotation findRotation = new FindRotation();
        System.out.println(findRotation.findRotation(new int[][]{{0,1,0,0},{0,0,0,1},{0,1,0,0},{0,1,1,1}}, new int[][]{{0,1,0,1},{0,0,0,1},{1,0,1,1},{0,0,0,0}}));
        System.out.println(findRotation.findRotation(new int[][]{{0,0},{1,0}}, new int[][]{{1,0},{0,0}}));
    }
}
