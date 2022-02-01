package javase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LearnList
 * @Description
 * @Author qsf
 * Date   2021-11-27  16:44
 */
public class LearnList {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);

        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        System.out.println(list2);
    }
}
