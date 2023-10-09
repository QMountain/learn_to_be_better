package algorithm.leetcode.medium.s;

import java.util.TreeMap;

public class StockPrice {

    TreeMap<Integer, Integer> map;
    TreeMap<Integer, Integer> priceMap;

    public StockPrice() {
        map = new TreeMap<>();
        priceMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            Integer oldPrice = map.get(timestamp);
            Integer oldCount = priceMap.get(oldPrice);
            priceMap.put(oldPrice, oldCount-1);
            while (!priceMap.isEmpty() && priceMap.firstEntry().getValue() == 0) {
                priceMap.pollFirstEntry();
            }
            while (!priceMap.isEmpty() && priceMap.lastEntry().getValue() == 0) {
                priceMap.pollLastEntry();
            }
        }
        map.put(timestamp, price);
        priceMap.put(price, priceMap.getOrDefault(price, 0)+1);
    }

    public int current() {
        return map.lastEntry().getValue();
    }

    public int maximum() {
        return priceMap.lastKey();
    }

    public int minimum() {
        return priceMap.firstKey();
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1,3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4,2);
        System.out.println(stockPrice.minimum());
    }
}
