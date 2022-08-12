package algorithm.leetcode.medium.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int length = groupSizes.length;
        for (int i = 0; i < length; i++) {
            int num = groupSizes[i];
            ArrayList<Integer> list = new ArrayList<>(map.getOrDefault(num, new ArrayList<>()));
            list.add(i);
            map.put(num,list);
        }
        List<List<Integer>> ansList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer groupSize = entry.getKey();
            List<Integer> people = entry.getValue();
            int size = people.size();
            for (int i = 0; i < size/groupSize; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = i*groupSize; j < (i+1) * groupSize; j++) {
                    list.add(people.get(j));
                }
                ansList.add(list);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        GroupThePeople groupThePeople = new GroupThePeople();
        System.out.println(groupThePeople.groupThePeople(new int[]{2,1,3,3,3,2}));
        System.out.println(groupThePeople.groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }
}
