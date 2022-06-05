package algorithm.leetcode.medium.c;

import java.util.*;

public class CalcEquation {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private static class UnionFind {

        private final int[] parent;

        /**
         * 指向的父结点的权值
         */
        private final double[] weight;


        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // 关系式的推导请见「参考代码」下方的示意图
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return 根结点的 id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }

    public static void main(String[] args) {
        CalcEquation calcEquation = new CalcEquation();
        List<List<String>> equations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        equations.add(equation1);
        List<String> equation2 = new ArrayList<>();
        equation2.add("e");
        equation2.add("f");
        equations.add(equation2);
        List<String> equation3 = new ArrayList<>();
        equation3.add("b");
        equation3.add("e");
        equations.add(equation3);
        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = new ArrayList<>();
        query1.add("b");
        query1.add("a");
        queries.add(query1);
        List<String> query2 = new ArrayList<>();
        query2.add("a");
        query2.add("f");
        queries.add(query2);
        List<String> query3 = new ArrayList<>();
        query3.add("f");
        query3.add("f");
        queries.add(query3);
        List<String> query4 = new ArrayList<>();
        query4.add("e");
        query4.add("e");
        queries.add(query4);
        List<String> query5 = new ArrayList<>();
        query5.add("c");
        query5.add("c");
        queries.add(query5);
        List<String> query6 = new ArrayList<>();
        query6.add("a");
        query6.add("c");
        queries.add(query6);
        List<String> query7 = new ArrayList<>();
        query7.add("f");
        query7.add("e");
        queries.add(query7);
        System.out.println(Arrays.toString(calcEquation.calcEquation(
                equations, new double[]{3.4d, 1.4d, 2.3d}, queries)));

        /*List<List<String>> equations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        equations.add(equation1);
        List<String> equation2 = new ArrayList<>();
        equation2.add("b");
        equation2.add("c");
        equations.add(equation2);
        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");
        queries.add(query1);
        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("a");
        queries.add(query2);
        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");
        queries.add(query3);
        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("a");
        queries.add(query4);
        List<String> query5 = new ArrayList<>();
        query5.add("x");
        query5.add("x");
        queries.add(query5);
        System.out.println(Arrays.toString(calcEquation.calcEquation(equations, new double[]{2.0d, 3.0d}, queries)));
    */}
}
