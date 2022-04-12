package javase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    // 请按这里筛选出数组中，未重复出现的元素 [3]
    public List<Integer> getUniqueNums(int[] array) {
        // 在这⾥书写你的代码
        Map<Integer,Integer> map = new HashMap<>(array.length);
        for (int i : array) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> list = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value.equals(1)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
    // 请在这里按照出现次数，对重复出现过的元素，根据出现次数由多到少进行排序 [5,2,3]
    public List<Integer> sortRepeatedNums(int[] array) {
        Map<Integer,Integer> map = new HashMap<>(array.length);
        for (int i : array) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            int index = findIndex(list, value);
            list.add(index,entry.getKey());
        }
        return list;
    }

    public int findIndex(List<Integer> list, Integer value) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            if (list.get(0) <= value) {
                return 0;
            }
            return 1;
        }
        if (value >= list.get(0)) {
            return 0;
        }
        int left = 0;
        int right = list.size()-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (list.get(mid-1) >= value && list.get(mid) <= value) {
                return mid;
            } else if (list.get(mid) < value) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getUniqueNums(new int[]{3, 2, 5, 2, 5, 5}));
        System.out.println(test.sortRepeatedNums(new int[]{3, 2, 5, 2, 5, 5}));
    }
}
