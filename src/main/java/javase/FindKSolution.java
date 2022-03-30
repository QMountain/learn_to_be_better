package javase;

/*
   题目:两个正序排序的数组，求合并后的第K个。(数组内元素没有重复数字; 数组没有 0，找不到第 K 个数可以返回 0)
   要求：不要申请额外的数组空间(List、Set、Map底层也是数组,不可使用)；

   示例 1：
   如果 K = 5
   >array1 = [1, 13, 16, 20]
   >array2 = [2, 8, 12, 27]
   >则第K个数是：13
*/
public class FindKSolution {
    public static int findK(int[] array1, int[] array2, int k) {
        int l1 = array1.length;
        int l2 = array2.length;
        int p1 = 0;
        int p2 = 0;
        while (p1+p2+1 <= k) {
            if (array1[p1] < array2[p2]) {
                if (p1+1+p2 == k) {
                    return array1[p1];
                }
                if (p1 < l1-1) {
                    p1++;
                } else {
                    if (p2 < l2-1) {
                        p2++;
                    }else {
                        break;
                    }
                }
            } else {
                if (p1+p2+1 == k) {
                    return array2[p2];
                }
                if (p2 < l2-1) {
                    p2++;
                } else {
                    if (p1 < l2-1) {
                        p1++;
                    } else {
                        break;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findK(new int[]{1, 3, 16,17,29}, new int[]{2, 8, 12, 27}, 8));
        System.out.println(findK(new int[]{1, 3, 16}, new int[]{2, 8, 12, 27}, 8));
        System.out.println(findK(new int[]{1, 3, 16, 20}, new int[]{2, 8, 12, 27}, 5));
        System.out.println(findK(new int[]{1, 13, 16, 20}, new int[]{2, 8, 12, 27}, 5));

    }
}
