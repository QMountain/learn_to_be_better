package algorithm.leetcode.easy.o;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    String[] arr;
    int ptr;
    int size;

    public OrderedStream(int n) {
        arr = new String[n];
        ptr = 0;
        size = n;
    }

    public List<String> insert(int idKey, String value) {
        arr[idKey-1] = value;
        List<String> list = new ArrayList<>(size);
        if (arr[ptr] != null) {
            for (int i = ptr; i < size; i++) {
                if (arr[i] != null) {
                    list.add(arr[i]);
                } else {
                    ptr = i;
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "ccccc"));
        System.out.println(orderedStream.insert(1, "aaaaa"));
        System.out.println(orderedStream.insert(2, "bbbbb"));
        System.out.println(orderedStream.insert(5, "eeeee"));
        System.out.println(orderedStream.insert(4, "ddddd"));
    }
}
