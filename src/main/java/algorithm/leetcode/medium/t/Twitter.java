package algorithm.leetcode.medium.t;

import java.util.*;

public class Twitter {

    int time = 0;
    Map<Integer, TreeMap<Integer,Integer>> userTimeTweeMap;
    Map<Integer, Set<Integer>> userFolloweeMap;

    public Twitter() {
        userTimeTweeMap = new HashMap<>();
        userFolloweeMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        TreeMap<Integer, Integer> oldTimeTweeMap = userTimeTweeMap.get(userId);
        TreeMap<Integer, Integer> newTimeTweeMap = new TreeMap<>();
        if (oldTimeTweeMap != null) {
            newTimeTweeMap.putAll(oldTimeTweeMap);
        }
        newTimeTweeMap.put(++time,tweetId);
        userTimeTweeMap.put(userId,newTimeTweeMap);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> resList = new ArrayList<>();
        Set<Integer> followerSet = userFolloweeMap.getOrDefault(userId,new HashSet<>());
        followerSet.add(userId);
        TreeMap<Integer,Integer> timeTweeMap = new TreeMap<>();
        for (Integer followerId : followerSet) {
            TreeMap<Integer, Integer> map = userTimeTweeMap.get(followerId);
            if (map != null && map.size() > 0) {
                ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
                int size = entries.size();
                for (int i = size-1; i >= 0 && i >= size-10; i--) {
                    Map.Entry<Integer, Integer> entry = entries.get(i);
                    Integer key = entry.getKey();
                    if (timeTweeMap.size() == 10) {
                        if (key > timeTweeMap.firstKey()) {
                            timeTweeMap.remove(timeTweeMap.firstKey());
                        }
                    }
                    timeTweeMap.put(key,entry.getValue());
                }
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(timeTweeMap.entrySet());
        int size = entries.size();
        for (int i = size-1; i >= 0 && i >= size-10; i--) {
            resList.add(entries.get(i).getValue());
        }
        return resList;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> oldSet = userFolloweeMap.get(followerId);
        Set<Integer> newSet = new HashSet<>();
        if (oldSet != null) {
            newSet.addAll(oldSet);
        }
        newSet.add(followeeId);
        userFolloweeMap.put(followerId,newSet);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> oldSet = userFolloweeMap.get(followerId);
        if (oldSet != null) {
            Set<Integer> newSet = new HashSet<>(oldSet);
            newSet.remove(followeeId);
            userFolloweeMap.put(followerId,newSet);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1,2);
        System.out.println(twitter.getNewsFeed(1));
    }
}
