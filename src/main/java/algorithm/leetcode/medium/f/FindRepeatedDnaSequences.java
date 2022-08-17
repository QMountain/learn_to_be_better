package algorithm.leetcode.medium.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ansList = new ArrayList<>();
        int length = s.length();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < length - 10; i++) {
            String curr = s.substring(i,i+10);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                ansList.add(entry.getKey());
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        FindRepeatedDnaSequences findRepeatedDnaSequences = new FindRepeatedDnaSequences();
        System.out.println(findRepeatedDnaSequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
