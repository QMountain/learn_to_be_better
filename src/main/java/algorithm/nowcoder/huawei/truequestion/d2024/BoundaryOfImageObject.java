package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// 图像物体的边界
public class BoundaryOfImageObject {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult(matrix, m, n));
    }

    public static int getResult(int[][] matrix, int m, int n) {
        // 上、下、左、右、左上、左下、右上、右下的横坐标、纵坐标偏移量
        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        // 记录所有边界位置
        HashSet<Integer> brands = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前点是像素5
                if (matrix[i][j] == 5) {

                    // 遍历像素5的相邻位置
                    for (int[] offset : offsets) {
                        int newI = i + offset[0];
                        int newJ = j + offset[1];

                        // 如果该位置不越界，且为像素1，则是边界
                        if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] == 1) {
                            brands.add(newI * n + newJ);
                        }
                    }
                }
            }
        }

        ArrayList<Integer> brands_list = new ArrayList<>(brands);
        int k = brands_list.size();

        // 使用并查集，对所有边界位置进行合并
        UnionFindSet ufs = new UnionFindSet(k);

        for (int i = 0; i < k; i++) {
            int x1 = brands_list.get(i) / n;
            int y1 = brands_list.get(i) % n;

            for (int j = i + 1; j < k; j++) {
                int x2 = brands_list.get(j) / n;
                int y2 = brands_list.get(j) % n;

                // 如果两个边界像素1的位置 横向、纵向距离均小于1，则相邻，可以进行合并
                if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1) {
                    ufs.union(i, j);
                }
            }
        }

        return ufs.count;
    }

    static class UnionFindSet {
        int[] fa;
        int count;

        public UnionFindSet(int n) {
            this.count = n;
            this.fa = new int[n];
            for (int i = 0; i < n; i++) this.fa[i] = i;
        }

        public int find(int x) {
            if (x != this.fa[x]) {
                return (this.fa[x] = this.find(this.fa[x]));
            }
            return x;
        }

        public void union(int x, int y) {
            int x_fa = this.find(x);
            int y_fa = this.find(y);

            if (x_fa != y_fa) {
                this.fa[y_fa] = x_fa;
                this.count--;
            }
        }
    }
}
