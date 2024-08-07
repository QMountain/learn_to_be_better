package algorithm.nowcoder.huawei.easy;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// HJ101 输入整型数组和排序标识，对其元素按照升序或降序进行排序
public class HJ101 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            int num = in.nextInt();
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int sort = in.nextInt();
        StringBuilder ans = new StringBuilder();
        if (sort == 0) {
            while (!map.isEmpty()) {
                Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
                Integer key = entry.getKey();
                for (Integer i = 0; i < entry.getValue(); i++) {
                    ans.append(key).append(" ");
                }
            }
            System.out.println(ans);
        } else {
            while (!map.isEmpty()) {
                Map.Entry<Integer, Integer> entry = map.pollLastEntry();
                Integer key = entry.getKey();
                for (Integer i = 0; i < entry.getValue(); i++) {
                    ans.append(key).append(" ");
                }
            }
            System.out.println(ans);
        }
    }
}
