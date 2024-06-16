package algorithm.leetcode.medium.f;

import java.util.*;

public class FindLUSlength {

    public int findLUSlength(String[] strs) {
        TreeMap<Integer, Map<String, Integer>> map = new TreeMap<>();
        for (String str : strs) {
            int key = str.length();
            Map<String, Integer> innerMap = map.getOrDefault(key, new HashMap<>());
            innerMap.put(str, innerMap.getOrDefault(str, 0) + 1);
            map.put(key, innerMap);
        }
        Set<String> longerStrSet = new HashSet<>();
        while (!map.isEmpty()) {
            Map.Entry<Integer, Map<String, Integer>> lastEntry = map.pollLastEntry();
            Map<String, Integer> innerMap = lastEntry.getValue();
            for (Map.Entry<String, Integer> entry : innerMap.entrySet()) {
                if (entry.getValue() == 1) {
                    boolean isSub = false;
                    for (String s : longerStrSet) {
                        if (isSub(s, entry.getKey())) {
                            isSub = true;
                            break;
                        }
                    }
                    if (!isSub) {
                        return lastEntry.getKey();
                    }
                }
                longerStrSet.add(entry.getKey());
            }
        }
        return -1;
    }

    public int findLUSlength2(String[] strs) {
        TreeMap<Integer, Set<String>> map = new TreeMap<>();
        Set<String> abortSet = new HashSet<>();
        for (String str : strs) {
            int length = str.length();
            Set<String> set = new HashSet<>(
                    map.getOrDefault(length,new HashSet<>()));
            if (!set.add(str)) {
                abortSet.add(str);
            }
            map.put(length,set);
        }
        ArrayList<Map.Entry<Integer, Set<String>>> entries =
                new ArrayList<>(map.entrySet());
        int size = entries.size();
        for (int i = size-1; i >= 0; i--) {
            Map.Entry<Integer, Set<String>> entry = entries.get(i);
            ArrayList<String> list = new ArrayList<>(entry.getValue());
            for (String s : list) {
                if (abortSet.contains(s)) {
                    continue;
                }
                boolean isSub = false;
                for (int j = size-1; j > i; j--) {
                    Map.Entry<Integer, Set<String>> setEntry = entries.get(j);
                    Set<String> value = setEntry.getValue();
                    boolean goNext = true;
                    for (String v : value) {
                        boolean sub = isSub(v, s);
                        if (sub) {
                            isSub = true;
                            goNext = false;
                            break;
                        }
                    }
                    if (!goNext) {
                        break;
                    }
                }
                if (!isSub) {
                    return entry.getKey();
                }
            }

        }
        return -1;
    }

    public boolean isSub(String root, String sub) {
        int rl = root.length();
        int sl = sub.length();
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr1 < rl && ptr2 < sl) {
            if (root.charAt(ptr1) == sub.charAt(ptr2)) {
                ptr1++;
                ptr2++;
            } else {
                ptr1++;
            }
        }
        return ptr2 == sl;
    }

    public static void main(String[] args) {
        FindLUSlength findLUSlength = new FindLUSlength();
        System.out.println(-1 == findLUSlength.findLUSlength(new String[]{"aaa","aaa","aa"}));
        System.out.println(3 == findLUSlength.findLUSlength(new String[]{"aba","cdc","eae"}));
    }
}
