package algorithm.leetcode.medium.a;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AuthenticationManager {

    int timeToLive;

    // token, deadTime
    HashMap<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime+timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            if (map.get(tokenId) <= currentTime) {
                map.remove(tokenId);
            } else {
                map.put(tokenId, currentTime+ timeToLive);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        AtomicInteger count = new AtomicInteger();
        map.forEach((token, deadTime) -> {
            if (deadTime > currentTime) {
                count.getAndIncrement();
            }
        });
        return count.get();
    }

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5);
        authenticationManager.renew("aaa",1);
        authenticationManager.generate("aaa",2);
        System.out.println(authenticationManager.countUnexpiredTokens(6));
        authenticationManager.generate("bbb",7);
        authenticationManager.renew("aaa",8);
        authenticationManager.renew("bbb",10);
        System.out.println(authenticationManager.countUnexpiredTokens(15));
    }
}
