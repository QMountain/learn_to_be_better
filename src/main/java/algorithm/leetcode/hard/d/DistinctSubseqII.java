package algorithm.leetcode.hard.d;

import java.util.*;

public class DistinctSubseqII {

    Map<String,Long> map = new HashMap<>();
    LinkedList<TreeMap<Integer,Integer>> indexList;
    int cs = 100_000_0007;

    String s;

    public int distinctSubseqII(String s) {
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        this.indexList = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            indexList.add(new TreeMap<>());
        }
        for (int i = 0; i < length; i++) {
            indexList.get(s.charAt(i)-'a').put(i,1);
        }
        this.s = s;
        return Integer.parseInt(String.valueOf(distinct(-1)));
    }

    public long distinct(int fromIndex) {
        if (s.length() == fromIndex+1) {
            return 1;
        }
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            // i 是开头字符
            // treeMap 是这个字符的index列表
            TreeMap<Integer, Integer> treeMap = indexList.get(i);
            // 这次使用 key作为下一个字符
            Integer key = treeMap.higherKey(fromIndex);
            int size = treeMap.tailMap(fromIndex).size();

            if (key != null) {
                ans++;
                String substring = s.substring(key + 1);
                if (!substring.equals("")) {
                    if (!map.containsKey(substring)) {
                        long i1 = distinct(key);
                        i1 %= cs;
                        map.put(substring,i1);
                        ans += i1;
                    } else {
                        ans += map.get(substring);
                    }
                }
            }
        }
        ans %= cs;
        return Integer.parseInt(String.valueOf(ans));
    }

    public static void main(String[] args) {
        DistinctSubseqII distinctSubseqII = new DistinctSubseqII();
        System.out.println(distinctSubseqII.distinctSubseqII("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn"));
        System.out.println(3 == distinctSubseqII.distinctSubseqII("aaa"));
        System.out.println(6 == distinctSubseqII.distinctSubseqII("aba"));
        System.out.println(7 == distinctSubseqII.distinctSubseqII("abc"));
    }
}
