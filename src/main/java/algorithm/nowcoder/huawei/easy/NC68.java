package algorithm.nowcoder.huawei.easy;

// NC68 跳台阶
public class NC68 {

    public int jumpFloor (int number) {
        if (number < 3) {
            return number;
        }
        int n_1 = 1;
        int n_2 = 2;
        for (int i = 2; i < number; i++) {
            int n_3 = n_1 + n_2;
            n_1 = n_2;
            n_2 = n_3;
        }
        return n_2;
    }
}
