package algorithm.leetcode.medium.k;

import algorithm.TreeNode;

import java.util.*;

public class KthSmallest {

    // 题号 378 有序矩阵中第K小的元素
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        boolean[][] visited = new boolean[length][length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> matrix[a[0]][a[1]]));
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        while (k > 1) {
            int[] top = queue.poll();
            k--;
            int x = top[0];
            int y = top[1];
            if (x < length-1 && !visited[x+1][y]) {
                queue.add(new int[]{x+1,y});
                visited[x+1][y] = true;
            }
            if (y < length-1 && !visited[x][y+1]) {
                queue.add(new int[]{x,y+1});
                visited[x][y+1] = true;
            }
        }
        int[] peek = queue.peek();
        return matrix[peek[0]][peek[1]];
    }

    public int kthSmallest(TreeNode root, int k) {
        Set<Integer> set = new TreeSet<>();
        addSet(root,set);
        List<Integer> list = new ArrayList<>(set);
        return list.get(k-1);
    }

    public void addSet(TreeNode root, Set<Integer> set) {
        if (root != null) {
            set.add(root.val);
            addSet(root.left,set);
            addSet(root.right,set);
        }
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(new int[][]{{-5}}, 1));
        System.out.println(kthSmallest.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));


        System.out.println(kthSmallest.kthSmallest(new TreeNode(3,
                        new TreeNode(1, null, new TreeNode(2)),
                        new TreeNode(4)),
                1));
    }
}
