package algorithm.leetcode.easy.a;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm {

    public List<Integer> addToArrayForm(int[] num, int k) {
        int length = num.length;
        for (int i = length-1; i >= 0; i--) {
            int sum = num[i] + k;
            num[i] = sum % 10;
            k = sum/10;
        }
        List<Integer> list = new ArrayList<>(length+1);
        if (k >= 1) {
            while (k >= 10) {
                list.add(0,k % 10);
                k /= 10;
            }
            list.add(0,k);
        }
        for (int i : num) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        AddToArrayForm addToArrayForm = new AddToArrayForm();
        System.out.println(addToArrayForm.addToArrayForm(new int[]{0}, 10000));
    }
}
