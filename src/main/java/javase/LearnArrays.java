package javase;

import java.util.Arrays;
import java.util.List;

public class LearnArrays {

    public static void main(String[] args) {
        final int[] arr = new int[2];
        arr[0] = 1;
        System.out.println(Arrays.toString(arr));
        List<Integer> list = Arrays.asList(1, 2);
        list.add(3);
        System.out.println(list);
    }
}
