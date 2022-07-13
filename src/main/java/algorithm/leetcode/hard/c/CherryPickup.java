package algorithm.leetcode.hard.c;

import java.util.Arrays;
import java.util.HashMap;

public class CherryPickup {

    int length;
    int max;
    boolean[][] checkArrToEnd;
    HashMap<String,Integer> map;

    public int cherryPickup(int[][] grid) {
        map = new HashMap<>();
        this.length = grid.length;
        checkArrToEnd = new boolean[length][length];
        checkArrToEnd[length-1][length-1] = true;
        for (int i = length-2; i >= 0; i--) {
            checkArrToEnd[length-1][i] = grid[length - 1][i] != -1 && checkArrToEnd[length - 1][i + 1];
            checkArrToEnd[i][length-1] = grid[i][length - 1] != -1 && checkArrToEnd[i + 1][length - 1];
        }
        for (int i = length-2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                checkArrToEnd[i][j] = grid[i][j] != -1 && (checkArrToEnd[i][j + 1] || checkArrToEnd[i + 1][j]);
            }
            for (int j = i; j >= 0; j--) {
                checkArrToEnd[j][i] = grid[j][i] != -1 && (checkArrToEnd[j][i + 1] || checkArrToEnd[j + 1][i]);
            }
        }
        this.max = 0;
        pickToEnd(getCopy(grid), 0, 0,0);
        return max;
    }

    public void pickToEnd(int[][] grid, int x, int y, int curr) {
        if (grid[x][y] == 1) {
            grid[x][y] = 0;
            curr++;
        }
        if (x == length-1 && y == length-1) {
            int[][] copy = getCopy(grid);
            String string = Arrays.deepToString(copy);
            if (map.containsKey(string) && map.get(string) >= curr) {
                return;
            }
            curr += pickToStart(copy,length-1,length-1,getCheckArrToStart(copy));
            map.put(string,curr);
            max = Math.max(max,curr);
            return;
        }
        if (x == length-1) {
            if (grid[x][y+1] != -1 && checkArrToEnd[x][y+1]) {
                pickToEnd(grid,x,y+1,curr);
            }
            return;
        }
        if (y == length-1) {
            if (grid[x+1][y] == -1 && checkArrToEnd[x+1][y]) {
                pickToEnd(grid, x+1, y,curr);
            }
            return;
        }
        // 可以向右
        if (grid[x][y+1] != -1 && checkArrToEnd[x][y+1]) {
            pickToEnd(getCopy(grid), x, y + 1,curr);
        }
        if (grid[x+1][y] != -1 && checkArrToEnd[x+1][y]) {
            pickToEnd(getCopy(grid),x+1,y,curr);
        }
    }

    public int pickToStart(int[][] grid, int x, int y, boolean[][] checkArrToStart) {
        int curr = grid[x][y] == 1 ? 1 : 0;
        if (x == 0 && y == 0) {
            return curr;
        }
        int max = -1;
        // 向上
        if (x > 0 && checkArrToStart[x-1][y]) {
            int pick = pickToStart(getCopy(grid), x - 1, y,checkArrToStart);
            if (pick != -1) {
                max = Math.max(max,pick+curr);
            }
        }
        // 向左
        if (y > 0 && checkArrToStart[x][y-1]) {
            int pick = pickToStart(getCopy(grid), x, y - 1,checkArrToStart);
            if (pick != -1) {
                max = Math.max(max,pick+curr);
            }
        }
        return max;
    }

    public int[][] getCopy(int[][] grid) {
        int[][] copy = new int[length][length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(grid[i], 0, copy[i], 0, length);
        }
        return copy;
    }

    public boolean[][] getCheckArrToStart(int[][] grid) {
        boolean[][] arr = new boolean[length][length];
        arr[0][0] = true;
        for (int i = 1; i < length; i++) {
            arr[0][i] = grid[0][i] != -1 && arr[0][i - 1];
            arr[i][0] = grid[i][0] != -1 && arr[i-1][0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = i; j < length; j++) {
                arr[i][j] = grid[i][j] != -1 && (arr[i][j-1] || arr[i-1][j]);
            }
            for (int j = i; j < length; j++) {
                arr[j][i] = grid[j][i] != -1 && (arr[j][i-1] || arr[j-1][i]);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        CherryPickup cherryPickup = new CherryPickup();
        System.out.println(cherryPickup.cherryPickup(new int[][]{{1,1,1,1,-1,-1,-1,1,0,0},{1,0,0,0,1,0,0,0,1,0},{0,0,1,1,1,1,0,1,1,1},{1,1,0,1,1,1,0,-1,1,1},{0,0,0,0,1,-1,0,0,1,-1},{1,0,1,1,1,0,0,-1,1,0},{1,1,0,1,0,0,1,0,1,-1},{1,-1,0,1,0,0,0,1,-1,1},{1,0,-1,0,-1,0,0,1,0,0},{0,0,-1,0,1,0,1,0,0,1}}));
        System.out.println(cherryPickup.cherryPickup(new int[][]{{0,1,1,0,0},{1,1,1,1,0},{-1,1,1,1,-1},{0,1,1,1,0},{1,0,-1,0,0}}));
        System.out.println(cherryPickup.cherryPickup(new int[][]{{0, 1, -1},
                {1, 0, -1},
                {1, 1,  1}}));
        System.out.println(cherryPickup.cherryPickup(new int[][]{{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}}));

    }
}
