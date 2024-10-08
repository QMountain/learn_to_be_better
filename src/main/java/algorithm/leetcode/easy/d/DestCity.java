package algorithm.leetcode.easy.d;

import java.util.*;

public class DestCity {

    public String destCity(List<List<String>> paths) {
        // true 终点， false 起点
        Map<String, Boolean> map = new HashMap<>();
        for (List<String> path : paths) {
            // 本次起点，直接标记false，不可能为终点
            map.put(path.get(0), false);
            String end = path.get(1);
            // 如果本次终点早就是起点了，那就还是作为起点，否则标记为终点
            Boolean orDefault = map.getOrDefault(end, true);
            map.put(end, orDefault);
        }
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DestCity destCity = new DestCity();
        String[][] arr = new String[][]{{"B","C"},{"D","B"},{"C","A"}};
        //String[][] arr = new String[][]{{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}};
        List<List<String>> paths = new ArrayList<>();
        for (String[] strings : arr) {
            List<String> path = new ArrayList<>();
            Collections.addAll(path, strings);
            paths.add(path);
        }
        System.out.println(destCity.destCity(paths));
    }
}
