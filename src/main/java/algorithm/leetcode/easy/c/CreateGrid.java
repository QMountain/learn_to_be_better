package algorithm.leetcode.easy.c;

public class CreateGrid {

    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append('#');
        }
        for (int i = 0; i < m - 1; i++) {
            ans[i] = "." + sb;
        }
        ans[m - 1] = ".";
        for (int i = 1; i < n; i++) {
            ans[m - 1] += ".";
        }
        return ans;
    }

    public static void main(String[] args) {
        CreateGrid createGrid = new CreateGrid();
    }
}
