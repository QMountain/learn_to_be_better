package algorithm.leetcode.medium;

import java.util.*;

public class GroupAnagrams {

    /*public List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;
        List<List<String>> resList = new ArrayList<>(length);
        if (length == 1) {
            resList.add(Collections.singletonList(strs[0]));
            return resList;
        }
        for (int i = 0; i < length-1; i++) {
            String str = strs[i];
            if (str != null) {
                List<String> list = new ArrayList<>(length);
                list.add(str);
                int strLength = str.length();
                for (int j = i+1; j < length; j++) {
                    String strJ = strs[j];
                    if (strJ != null) {
                        if (str.equals(strJ)) {
                            list.add(strJ);
                            strs[j] = null;
                            continue;
                        }
                        int strJLen = strJ.length();
                        if (strLength == strJLen) {
                            String strJCopy = strJ;
                            for (int k = 0; k < strLength; k++) {
                                char c = str.charAt(k);
                                strJCopy = strJCopy.replaceFirst(c+"","");
                            }
                            if (strJCopy.equals("")) {
                                list.add(strJ);
                                strs[j] = null;
                            }
                        }
                    }
                }
                resList.add(list);
            }
        }
        if (strs[length - 1] != null) {
            resList.add(Collections.singletonList(strs[length-1]));
        }
        return resList;
    }*/

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s,list);
        }
        List<List<String>> resList = new ArrayList<>(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            resList.add(value);
        }
        return resList;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams.groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"a"}));
    }
}
