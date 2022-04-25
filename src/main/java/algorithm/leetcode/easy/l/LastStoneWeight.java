package algorithm.leetcode.easy.l;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        int length = stones.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return stones[0];
        }
        int first = Math.max(stones[0],stones[1]);
        int second = Math.min(stones[0],stones[1]);
        for (int i = 2; i < length; i++) {
            if (stones[i] >= first) {
                second = first;
                first = stones[i];
            } else if (stones[i] >= second) {
                second = stones[i];
            }
        }
        if (first == second) {
            int[] arr = new int[length-2];
            int cut = 2;
            int i = 0;
            for (int stone : stones) {
                if (stone != first) {
                    arr[i] = stone;
                    i++;
                } else {
                    if (cut > 0) {
                        cut--;
                    } else {
                        arr[i] = stone;
                        i++;
                    }
                }
            }
            return lastStoneWeight(arr);
        }
        int[] arr = new int[length-1];
        boolean cutFirst = false;
        boolean cutSecond = false;
        int i = 0;
        for (int stone : stones) {
            if (stone != first && stone != second) {
                arr[i] = stone;
                i++;
            } else {
                if (stone == first && !cutFirst) {
                    cutFirst = true;
                } else if (stone == second && !cutSecond){
                    cutSecond = true;
                } else {
                    arr[i] = stone;
                    i++;
                }
            }
        }
        arr[length-2] = first-second;
        return lastStoneWeight(arr);
    }

}
