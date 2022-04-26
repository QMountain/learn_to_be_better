package algorithm.leetcode.medium.s;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        List<Integer> list = new ArrayList<>();
        list.add(matrix[0][0]);
        add(matrix,0,0,0,set,list);
        return list;
    }

    public void add(int[][] matrix, int x, int y, int towards,
                    Set<String> set, List<Integer> list) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        boolean canUp = x > 0 && !set.contains((x-1)+","+y);
        boolean canRight = y < colCount-1 && !set.contains(x+","+(y+1));
        boolean canDown = x < rowCount-1 && !set.contains((x+1)+","+y);
        boolean canLeft = y > 0 && !set.contains(x+","+(y-1));

        if (!canUp && !canRight && !canDown && !canLeft) {
            return;
        }

        // first up
        if (towards == 0) {
            if (x == 0) {
                // towards right
                add(matrix,x,y,1,set,list);
            } else {
                String p = (x-1) + "," + y;
                if (set.contains(p)) {
                    // towards right
                    add(matrix,x,y,1,set,list);
                } else {
                    set.add(p);
                    list.add(matrix[x-1][y]);
                    add(matrix,x-1,y,0,set,list);
                }
            }
        }
        if (towards == 1) {
            if (y == colCount-1) {
                // turn to down
                add(matrix,x,y,2,set,list);
            } else {
                String p = x + "," + (y+1);
                if (set.contains(p)) {
                    // turn to down
                    add(matrix,x,y,2,set,list);
                } else {
                    set.add(p);
                    list.add(matrix[x][y+1]);
                    add(matrix,x,y+1,1,set,list);
                }
            }
        }
        if (towards == 2) {
            if (x == rowCount-1) {
                // turn to left
                add(matrix,x,y,3,set,list);
            } else {
                String p = (x+1) + "," + y;
                if (set.contains(p)) {
                    // turn to left
                    add(matrix,x,y,3,set,list);
                } else {
                    set.add(p);
                    list.add(matrix[x+1][y]);
                    add(matrix,x+1,y,2,set,list);
                }
            }
        }
        if (towards == 3) {
            if (y == 0) {
                // turn to up
                add(matrix,x,y,0,set,list);
            } else {
                String p = x + "," + (y-1);
                if (set.contains(p)) {
                    // turn to up
                    add(matrix,x,y,0,set,list);
                } else {
                    set.add(p);
                    list.add(matrix[x][y-1]);
                    add(matrix,x,y-1,3,set,list);
                }
            }
        }
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(spiralOrder.spiralOrder(new int[][]{{3},{2}}));
        System.out.println(spiralOrder.spiralOrder(new int[][]{{1}}));
        System.out.println(spiralOrder.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(spiralOrder.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
