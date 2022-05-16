package algorithm.leetcode.hard.m;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximumRequests {

    public int maximumRequests(int n, int[][] requests) {
        int res = 0;
        Map<String,Integer> container = new HashMap<>(requests.length);
        for (int[] request : requests) {
            int from = request[0];
            int to = request[1];
            if (from == to) {
                res++;
            } else {
                String currentKey = from + "," + to;
                container.put(currentKey,container.getOrDefault(currentKey,0)+1);
            }
        }

        Map<Integer,Integer> fromMap = new HashMap<>(container.size()/2);
        Map<Integer,Integer> toMap = new HashMap<>(container.size()/2);

        container.forEach((k,v) -> {
            String[] split = k.split(",");
            Integer from = Integer.valueOf(split[0]);
            Integer to = Integer.valueOf(split[1]);
            if (fromMap.containsKey(from)) {
                fromMap.put(from, fromMap.get(from)+v);
            } else {
                fromMap.put(from, v);
            }
            if (toMap.containsKey(to)) {
                toMap.put(to,toMap.get(to)+v);
            } else {
                toMap.put(to,v);
            }
        });


        boolean needCut = true;
        while (needCut && container.size()>0) {
            boolean willCut = false;
            Set<Integer> needCutAllFromKey = new HashSet<>();
            Set<Integer> needCutAllToKey = new HashSet<>();
            Map<Integer,Integer> needCutPartFrom = new HashMap<>();
            Map<Integer,Integer> needCutPartTo = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : fromMap.entrySet()) {
                Integer fk = entry.getKey();
                Integer fv = entry.getValue();
                Integer tv = toMap.getOrDefault(fk, 0);
                if (!Objects.equals(fv, tv)) {
                    willCut = true;
                    if (fv != 0 && tv == 0) {
                        needCutAllFromKey.add(fk);
                    } else if (fv == 0) {
                        needCutAllToKey.add(fk);
                    } else if (fv > tv) {
                        needCutPartFrom.put(fk,fv-tv);
                    } else {
                        needCutPartTo.put(fk,tv-fv);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : toMap.entrySet()) {
                Integer tk = entry.getKey();
                Integer tv = entry.getValue();
                Integer fv = fromMap.getOrDefault(tk, 0);
                if (!Objects.equals(fv, tv)) {
                    willCut = true;
                    if (fv != 0 && tv == 0) {
                        needCutAllFromKey.add(tk);
                    } else if (fv == 0) {
                        needCutAllToKey.add(tk);
                    } else if (fv > tv) {
                        needCutPartFrom.put(tk,fv-tv);
                    } else {
                        needCutPartTo.put(tk,tv-fv);
                    }
                }
            }
            for (Integer from : needCutAllFromKey) {
                for (int i = 0; i < n; i++) {
                    String key = from + "," +i;
                    container.remove(key);
                }
            }
            for (Integer to : needCutAllToKey) {
                for (int i = 0; i < n; i++) {
                    String key = i + "," +to;
                    container.remove(key);
                }
            }
            if (container.size()>0) {
                needCutPartFrom.forEach((k,v) -> {
                    for (int i = 0; i < n; i++) {
                        String key = k + "," +i;
                        container.put(key,container.get(key)-v);
                    }
                });
            }
            if (container.size()>0){
                needCutPartTo.forEach((k,v) -> {
                    for (int i = 0; i < n; i++) {
                        String key = i + "," +k;
                        container.put(key,container.get(key)-v);
                    }
                });
            }

            if (!willCut) {
                needCut = false;
            }
        }

        AtomicInteger totalCount = new AtomicInteger();
        container.forEach((k,v) -> totalCount.addAndGet(v));
        res += totalCount.get();

        return res;
    }

    public static void main(String[] args) {
        MaximumRequests maximumRequests = new MaximumRequests();
        System.out.println(5 == maximumRequests.maximumRequests(5, new int[][]{{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}}));
        System.out.println(3 == maximumRequests.maximumRequests(5, new int[][]{{0,0},{1,2},{2,1}}));
        System.out.println(4 == maximumRequests.maximumRequests(4, new int[][]{{0,3},{3,1},{1,2},{2,0}}));
        System.out.println(7 == maximumRequests.maximumRequests(3, new int[][]{{1,2},{0,0},{0,2},{0,1},{0,0},{0,2},{1,0},{0,1},{2,0}}));
        System.out.println(5 == maximumRequests.maximumRequests(3, new int[][]{{0,0},{1,1},{0,0},{2,0},{2,2},{1,1},{2,1},{0,1},{0,1}}));
    }

}
