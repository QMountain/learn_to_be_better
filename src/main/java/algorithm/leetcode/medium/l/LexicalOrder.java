package algorithm.leetcode.medium.l;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int x = 1;
        while (x <= n) {
            list.add(x);
            if (x * 10 <= n) {
                x *= 10;
            } else if (x + 1 <= n && ((x / 10 == (x+1)/10))){
                x += 1;
            } else {
                x /= 10;
                x++;
                if (list.contains(x)) {
                    break;
                }
                while (x % 10 == 0) {
                    x /= 10;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        LexicalOrder lexicalOrder = new LexicalOrder();
        System.out.println(lexicalOrder.lexicalOrder(192));
        System.out.println(lexicalOrder.lexicalOrder(13));
    }
}
