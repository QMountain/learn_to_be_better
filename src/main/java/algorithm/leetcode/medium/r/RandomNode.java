package algorithm.leetcode.medium.r;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 题号 382 链表随机节点
 *
 * 可以学习了解下 池塘采样，大数据处理可能用得到
 */
public class RandomNode {

    List<Integer> list;

    public RandomNode(ListNode head) {
        this.list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        RandomNode randomNode = new RandomNode(new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(randomNode.getRandom());
    }
}
