package algorithm.leetcode.hard.r;

import java.util.ArrayList;
import java.util.List;

public class RectangleArea {

    List<int[]> list;

    public int rectangleArea(int[][] rectangles) {
        list = new ArrayList<>();
        for (int[] rectangle : rectangles) {
            add(rectangle[0],rectangle[1], rectangle[2],rectangle[3]);
        }
        int ans = 0;
        /*for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            long v = (long) (value[2] - value[0]) * (value[3]-value[1]);
            ans += v % 100_000_0007;
        }*/
        return ans;
    }

    public void add(int x1, int y1, int x2, int y2) {
        boolean deal = false;
        List<int[]> nList = new ArrayList<>();
        for (int[] ints : list) {
            int currX1 = ints[0];
            int currY1 = ints[1];
            int currX2 = ints[2];
            int currY2 = ints[3];
            if (currX1 >= x2 || currX2 <= x1 || currY1 >= y2 || currY2 <= y1) {
                nList.add(ints);
                continue;
            }

        }
        if (!deal) {
            nList.add(x1,new int[]{x1,y1,x2,y2});
        }
        list = nList;
        /*for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            Integer left = entry.getKey();
            if (x2 <= left) {
                break;
            }
            int[] currSegment = entry.getValue();
            int right = currSegment[2];
            if (right <= x1) {
                continue;
            }
            if (x1 >= left && x2 <= right) {
                if (x1 > left) {
                    map.put(left,new int[]{left,currSegment[1],x1,currSegment[3]});
                }
                map.put(x1,new int[]{x1,Math.min(currSegment[1],y1),x2,Math.max(currSegment[3],y2)});
                if (x2 < right) {
                    map.put(x2,new int[]{x2,currSegment[1],right,currSegment[3]});
                }
                deal = true;
                break;
            }
            if (x1 <= left && x2 >= right) {
                if (x1 < left) {
                    add(x1,y1,left,y2);
                }
                map.put(left,new int[]{left,Math.min(currSegment[1],y1),right,Math.max(currSegment[3],y2)});
                if (x2 > right) {
                    add(right,y1,x2,y2);
                }
                deal= true;
                break;
            }
            if (x1 <= left) {
                add(x1,y1,left,y2);
                map.put(left,new int[]{left,Math.min(currSegment[1],y1),x2,Math.max(currSegment[3],y2)});
                map.put(x2,new int[]{x2,currSegment[1],right,currSegment[3]});
                deal = true;
                break;
            }
            map.put(left,new int[]{left,currSegment[1],x1,currSegment[3]});
            map.put(x1,new int[]{x1,Math.min(currSegment[1],y1),right,Math.max(currSegment[3],y2)});
            add(right,y1,x2,y2);
            deal = true;
            break;
        }*/

    }

    public static void main(String[] args) {
        RectangleArea rectangleArea = new RectangleArea();
        System.out.println(49 == rectangleArea.rectangleArea(new int[][]{{25,20,70,27},{68,80,79,100},{37,41,66,76}}));
        System.out.println(49 == rectangleArea.rectangleArea(new int[][]{{0,0,3,3},{2,0,5,3},{1,1,4,4}}));
        System.out.println(49 == rectangleArea.rectangleArea(new int[][]{{0,0,1000000000,1000000000}}));
        System.out.println(6 == rectangleArea.rectangleArea(new int[][]{{0,0,2,2},{1,0,2,3},{1,0,3,1}}));
    }
}
