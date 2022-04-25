package algorithm.leetcode.easy.l;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int length = bills.length;
        Map<Integer,Integer> map = new HashMap<>(length);
        for (int bill : bills) {
            if (bill == 5) {
                map.put(5,map.getOrDefault(5,0)+1);
            } else if (bill == 10) {
                Integer left5 = map.getOrDefault(5, 0);
                if (left5 > 0) {
                    map.put(5,map.get(5)-1);
                    map.put(10,map.getOrDefault(10,0)+1);
                } else {
                    return false;
                }
            } else {
                Integer left5 = map.getOrDefault(5, 0);
                Integer left10 = map.getOrDefault(10, 0);
                if (left5 > 0 && left10 > 0) {
                    map.put(5,map.get(5)-1);
                    map.put(10,map.get(10)-1);
                    map.put(20,map.getOrDefault(20,0)+1);
                } else if (left5 >= 3){
                    map.put(5,map.get(5)-3);
                    map.put(20,map.getOrDefault(20,0)+1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
