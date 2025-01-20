package algorithm.leetcode.medium.m;

import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MinOperations {

    // 2 <= nums.length <= 2 * 10^5
    // 1 <= nums[i] <= 10^9
    // 1 <= k <= 10^9
    // 输入保证答案一定存在，也就是说一定存在一个操作序列使数组中所有元素都大于等于 k 。
    public int minOperations(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (num < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int count = 0;
        Integer before = null;
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> firstEntry = map.pollFirstEntry();
            Integer key = firstEntry.getKey();
            Integer value = firstEntry.getValue();
            if (before != null) {
                long calNextKey = (before * 2L) + key;
                if (calNextKey < k) {
                    map.put((int) calNextKey, map.getOrDefault((int) calNextKey, 0) + 1);
                }
                count++;
                value--;
                before = null;
            }
            if (value == 0) {
                continue;
            }
            if (value % 2 == 0 || value > 1) {
                count += value >> 1;
                long calNextKey = key * 3L;
                if (calNextKey < k) {
                    map.put((int) calNextKey, map.getOrDefault((int) calNextKey, 0) + (value >> 1));
                }
                value %= 2;
            }
            if (value == 1) {
                before = key;
            }
        }
        return count + (before == null ? 0 : 1);
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        System.out.println(233 == minOperations.minOperations(new int[]{838143973,477351988,121052388,
                770379303,105782152,708118500,882588219,230253017,560587152,
                397812337,643659612,601669668,771566414,962841450,810570350,
                544112871,799440717,329394454,787479395,205804609,629495304,
                899596311,144367425,304673518,393268041,202097336,819086349,
                884429174,270160705,527867855,521668021,343471570,537647818,
                866769125,217349099,935243686,321440158,32216125,43831964,812794341,
                860502677,338072008,260037766,470798181,678378133,290630090,584827892,519305975,
                117091652,966531836,777810877,863527565,744838858,612993326,884537124,611989640,
                186971728,812479399,27920770,69659259,646195084,567861321,312323780,513124936,
                630784171,293419536,627356157,588890365,792166297,373660002,
                752459117,121752076,512645203,427751912,923398172,958763879,642285281,732147783,
                342580005,802416393,859828446,396259566,745686562,907101150,124786437,254985881,
                458012611,454198810,865645378,72261777,3339254,894916237,827283202,185860947,
                564513716,451469180,481172251,940823958,662251478,369330609}, 999999998));
        System.out.println(4 == minOperations.minOperations(new int[]{55,72,67,30,8,30}, 73));
        System.out.println(6 == minOperations.minOperations(new int[]{100,97,57,89,96,100,47,46,28,4}, 101));
        System.out.println(2 == minOperations.minOperations(new int[]{999999999,999999999,999999999}, 1000000000));
        System.out.println(4 == minOperations.minOperations(new int[]{1,1,2,4,9}, 20));
        System.out.println(2 == minOperations.minOperations(new int[]{2,11,10,1,3}, 10));
    }
}
