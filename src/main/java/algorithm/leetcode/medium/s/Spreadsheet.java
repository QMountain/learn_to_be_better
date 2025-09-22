package algorithm.leetcode.medium.s;

// 1 <= rows <= 10^3
// 0 <= value <= 10^5
// 公式保证采用 "=X+Y" 格式，其中 X 和 Y 要么是有效的单元格引用，要么是小于等于 10^5 的 非负 整数。
// 每个单元格引用由一个大写字母 'A' 到 'Z' 和一个介于 1 和 rows 之间的行号组成。
// 总共 最多会对 setCell、resetCell 和 getValue 调用 10^4 次。
public class Spreadsheet {

    int[][] grid;

    public Spreadsheet(int rows) {
        grid = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        grid[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        grid[row][col] = 0;
    }

    // "=A1+B2"
    // "=A1+6"
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] split = formula.split("\\+");
        int num1;
        if (Character.isDigit(split[0].charAt(0))) {
            num1 = Integer.parseInt(split[0]);
        } else {
            int col = split[0].charAt(0) - 'A';
            int row = Integer.parseInt(split[0].substring(1)) - 1;
            num1 = grid[row][col];
        }

        int num2;
        if (Character.isDigit(split[1].charAt(0))) {
            num2 = Integer.parseInt(split[1]);
        } else {
            int col = split[1].charAt(0) - 'A';
            int row = Integer.parseInt(split[1].substring(1)) - 1;
            num2 = grid[row][col];
        }

        return num1 + num2;
    }

}
