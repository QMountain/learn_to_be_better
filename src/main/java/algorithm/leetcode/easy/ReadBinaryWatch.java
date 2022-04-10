package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadBinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        // 0个灯, 0点
        int[] arrHour0 = {0};
        // 1个灯
        int[] arrHour1 = {1,2,4,8};
        // 2个灯
        int[] arrHour2 = {3,5,6,9,10};
        // 3个灯
        int[] arrHour3 = {7,11};
        Map<Integer,List<Integer>> map = new HashMap<>(60);
        for (int i = 0; i < 60; i++) {
            int bc = Integer.bitCount(i);
            ArrayList<Integer> list = new ArrayList<>(map.getOrDefault(bc, new ArrayList<>()));
            list.add(i);
            map.put(bc,list);
        }
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < 4 && i <= turnedOn; i++) {
            List<Integer> list = map.get(turnedOn - i);
            if (list != null && list.size() > 0) {
                int[] arrHour;
                if (i == 0) {
                    arrHour = arrHour0;
                } else if (i == 1) {
                    arrHour = arrHour1;
                } else if (i == 2) {
                    arrHour = arrHour2;
                } else {
                    arrHour = arrHour3;
                }
                for (int hour : arrHour) {
                    for (Integer minute : list) {
                        if (minute < 10) {
                            resList.add(hour+":0"+minute);
                        } else {
                            resList.add(hour+":"+minute);
                        }
                    }
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        ReadBinaryWatch readBinaryWatch = new ReadBinaryWatch();
        System.out.println(readBinaryWatch.readBinaryWatch(9));
    }
}
