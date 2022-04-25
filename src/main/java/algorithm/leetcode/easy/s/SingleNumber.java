package algorithm.leetcode.easy.s;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            boolean lonely = true;
            for (int j = i+1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    lonely = false;
                    if (j != i+1) {
                        int temp = nums[i+1];
                        nums[i+1] = nums[j];
                        nums[j] = temp;
                    }
                    i++;
                }
            }
            if (lonely) {
                return nums[i];
            }
        }

        return 0;
    }

    //异或运算有以下三个性质。
    //任何数和 00 做异或运算，结果仍然是原来的数，即 a 异或 0=aa⊕0=a。
    //任何数和其自身做异或运算，结果是 00，即 a 异或s a=0a⊕a=0。
    //异或运算满足交换律和结合律，即 a 异或 b 异或 a=b 异或 a 异或 a=b 异或 (a 异或 a)=b 异或 0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(1 == singleNumber.singleNumber(new int[]{2,2,1}));
        System.out.println(4 == singleNumber.singleNumber(new int[]{4,1,2,1,2}));

    }
}
