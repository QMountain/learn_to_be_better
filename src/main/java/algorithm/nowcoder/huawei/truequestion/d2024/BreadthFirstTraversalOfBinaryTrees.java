package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

// 二叉树的广度优先遍历
public class BreadthFirstTraversalOfBinaryTrees {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String post = sc.next();
        String mid = sc.next();

        System.out.println(getResult(post, mid));
    }

    /**
     * @param post 后序遍历结果
     * @param mid 中序遍历结果
     * @return 层序遍历结果
     */
    public static String getResult(String post, String mid) {
        // 广度优先搜索的执行队列，先加入左子树，再加入右子树
        LinkedList<String[]> queue = new LinkedList<>();
        // 层序遍历出来的元素存放在ans中
        ArrayList<Character> ans = new ArrayList<>();

        devideLR(post, mid, queue, ans);

        while (queue.size() > 0) {
            String[] tmp = queue.removeFirst();
            devideLR(tmp[0], tmp[1], queue, ans);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : ans) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 本方法用于从后序遍历、中序遍历序列中分离出：根，以及其左、右子树的后序、中序遍历序列
     *
     * @param post 后序遍历结果
     * @param mid 中序遍历结果
     * @param queue BFS的执行队列
     * @param ans 题解
     */
    public static void devideLR(
            String post, String mid, LinkedList<String[]> queue, ArrayList<Character> ans) {
        // 后序遍历的最后一个元素就是根
        char rootEle = post.charAt(post.length() - 1);
        // 将根加入题解
        ans.add(rootEle);

        // 在中序遍历中找到根的位置rootIdx，那么该位置左边就是左子树，右边就是右子树
        int rootIdx = mid.indexOf(rootEle);

        // 左子树长度，左子树是中序遍历的0~rootIdx-1范围，长度为rootIdx
        int leftLen = rootIdx;

        // 如果存在左子树，即左子树长度大于0
        if (leftLen > 0) {
            // 则从后序遍历中，截取出左子树的后序遍历
            String leftPost = post.substring(0, leftLen);
            // 从中序遍历中，截取出左子树的中序遍历
            String leftMid = mid.substring(0, rootIdx);
            // 将左子树的后、中遍历序列加入执行队列
            queue.addLast(new String[] {leftPost, leftMid});
        }

        // 如果存在右子树，即右子树长度大于0
        if (post.length() - 1 - leftLen > 0) {
            // 则从后序遍历中，截取出右子树的后序遍历
            String rightPost = post.substring(leftLen, post.length() - 1);
            // 从中序遍历中，截取出右子树的中序遍历
            String rightMid = mid.substring(rootIdx + 1);
            // 将右子树的后、中遍历序列加入执行队列
            queue.addLast(new String[] {rightPost, rightMid});
        }
    }

}
