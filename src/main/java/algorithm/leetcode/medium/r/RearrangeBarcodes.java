package algorithm.leetcode.medium.r;

import java.util.*;

public class RearrangeBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0)+1);
        }
        LinkedList<int[]> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        list.sort(Comparator.comparingInt(a -> a[1]));
        int setIndex = 0;
        int getIndex = list.size()-1;
        while (setIndex < barcodes.length) {
            barcodes[setIndex++] = list.get(getIndex)[0];
            if (--list.get(getIndex)[1] == 0) {
                list.remove(getIndex);
                if (getIndex == list.size()) {
                    getIndex--;
                }
                continue;
            }
            if (getIndex == list.size() - 1) {
                getIndex--;
                if (getIndex < 0) {
                    break;
                }
                continue;
            }
            if (getIndex == 0) {
                getIndex++;
                if (getIndex >= list.size()) {
                    break;
                }
                continue;
            }
            // 右侧还是多
            if (list.get(getIndex+1)[1] >= list.get(getIndex-1)[1]) {
                getIndex++;
                continue;
            }
            getIndex--;
        }
        return barcodes;
    }

    public static void main(String[] args) {
        RearrangeBarcodes rearrangeBarcodes = new RearrangeBarcodes();
        System.out.println(Arrays.toString(rearrangeBarcodes.rearrangeBarcodes(
                new int[]{51,83,51,40,51,40,51,40,83,40,83,83,51,40,40,51,51,51,40,
                        40,40,83,51,51,40,51,51,40,40,51,51,40,51,51,51,40,83,40,40,
                        83,51,51,51,40,40,40,51,51,83,83,40,51,51,40,40,40,51,40,83,
                        40,83,40,83,40,51,51,40,51,51,51,51,40,51,83,51,83,51,51,40,
                        51,40,51,40,51,40,40,51,51,51,40,51,83,51,51,51,40,51,51,40,40})));
        System.out.println(Arrays.toString(rearrangeBarcodes.rearrangeBarcodes(
                new int[]{1,1,1,1,2,2,3,3})));
        System.out.println(Arrays.toString(rearrangeBarcodes.rearrangeBarcodes(
                new int[]{1,1,1,2,2,2})));
    }

}
