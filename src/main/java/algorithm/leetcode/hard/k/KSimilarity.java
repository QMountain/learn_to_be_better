package algorithm.leetcode.hard.k;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class KSimilarity {

    public int kSimilarity(String s1, String s2) {
        int length = s1.length();
        Map<Character,Set<Character>> pair = new HashMap<>();
        Map<String,Integer> pairCount = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                HashSet<Character> set = new HashSet<>(pair.getOrDefault(c1, new HashSet<>()));
                set.add(c2);
                pair.put(c1,set);
                String key = c1 + "," + c2;
                pairCount.put(key,pairCount.getOrDefault(key,0)+1);
            }
        }
        AtomicInteger total = new AtomicInteger();
        pairCount.forEach((k,v)->{
            total.addAndGet(v);
        });
        int i = canBuildMostCircle(pair, pairCount);
        return total.get() - i;
    }

    public int canBuildMostCircle(Map<Character,Set<Character>> pair, Map<String,Integer> pairCount) {
        if (pair.size() == 0) {
            return 0;
        }
        List<List<Character>> circleList = buildCircle(new ArrayList<>(pair.keySet()).get(0),pair);
        int mostCircle = 1;
        for (List<Character> list : circleList) {
            Map<Character,Set<Character>> pairCopy = new HashMap<>(pair);
            Map<String,Integer> pairCountCopy= new HashMap<>(pairCount);
            if (removeCharInList(list,pairCopy,pairCountCopy)) {
                int next = canBuildMostCircle(pairCopy, pairCountCopy);
                mostCircle = Math.max(mostCircle,next+1);
            }
        }
        return mostCircle;
    }

    public List<List<Character>> buildCircle(char startChar,Map<Character,Set<Character>> pair) {
        List<List<Character>> ansList = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        list.add(startChar);
        ansList.add(list);
        while (true) {
            boolean addNew = false;
            List<List<Character>> circleListNew = new ArrayList<>();
            for (List<Character> circleList : ansList) {
                Character lastChar = circleList.get(circleList.size() - 1);
                if (lastChar != '.') {
                    Set<Character> set = pair.get(lastChar);
                    for (Character c2 : set) {
                        ArrayList<Character> ccn = new ArrayList<>(circleList);
                        if (ccn.get(0) == c2) {
                            ccn.add('.');
                            circleListNew.add(ccn);
                            addNew = true;
                        } else if (!ccn.contains(c2)) {
                            ccn.add(c2);
                            circleListNew.add(ccn);
                            addNew = true;
                        }
                    }
                } else {
                    circleListNew.add(new ArrayList<>(circleList));
                }
            }
            if (!addNew) {
                break;
            }
            ansList = circleListNew;
        }
        return ansList;
    }

    public boolean removeInMap(char c1, char c2, Map<Character,Set<Character>> pair,Map<String,Integer> pairCount) {
        Set<Character> set = pair.get(c1);
        String key = c1 + "," + c2;
        Integer oldCount = pairCount.get(key);
        if (oldCount == null) {
            return false;
        }
        if (oldCount > 1) {
            pairCount.put(key,oldCount-1);
        } else {
            pairCount.remove(key);
            if (set.size() > 1) {
                HashSet<Character> ns = new HashSet<>(set);
                ns.remove(c2);
                pair.put(c1,ns);
            } else {
                pair.remove(c1);
            }
        }
        return true;
    }

    public boolean removeCharInList(List<Character> list, Map<Character,Set<Character>> pair,Map<String,Integer> pairCount) {
        int size = list.size();
        for (int i = 0; i < size - 2; i++) {
            char c1 = list.get(i);
            char c2 = list.get(i+1);
            if (!removeInMap(c1,c2,pair,pairCount)) {
                return false;
            }
        }
        return removeInMap(list.get(size - 2), list.get(0), pair, pairCount);
    }

    public static void main(String[] args) {
        KSimilarity kSimilarity = new KSimilarity();
        System.out.println(10 == kSimilarity.kSimilarity("abcdefabcdefabcdef", "edcfbebceafcfdabad"));
        System.out.println(5 == kSimilarity.kSimilarity("cdebcdeadedaaaebfbcf", "baaddacfedebefdabecc"));
        System.out.println(5 == kSimilarity.kSimilarity("aabbccddee", "dcacbedbae"));
        System.out.println(2 == kSimilarity.kSimilarity("abc", "bca"));
        System.out.println(1 == kSimilarity.kSimilarity("ab", "ba"));
    }
}
