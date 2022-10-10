package algorithm.leetcode.easy.p;

public class PerfectMenu {

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int length = attribute.length;
        int max = (1 << (length + 1)) - 1;
        int maxDelicious = -1;
        for (int i = 1; i <= max; i++) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
            while (sb.length() < length) {
                sb.insert(0, "0");
            }
            int delicious = 0;
            int fullFeeling = 0;
            int[] countM = new int[5];
            for (int j = 0; j < length; j++) {
                if (sb.charAt(j) == '1') {
                    delicious += attribute[j][0];
                    fullFeeling += attribute[j][1];
                    for (int k = 0; k < 5; k++) {
                        countM[k] += cookbooks[j][k];
                    }
                }
            }
            if (fullFeeling >= limit) {
                boolean canMake = true;
                for (int j = 0; j < 5; j++) {
                    if (countM[j] > materials[j]) {
                        canMake = false;
                        break;
                    }
                }
                if (canMake) {
                    maxDelicious = Math.max(maxDelicious,delicious);
                }
            }
        }
        return maxDelicious;
    }

}
