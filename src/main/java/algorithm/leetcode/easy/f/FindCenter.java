package algorithm.leetcode.easy.f;

/**
 * @ClassName FindCenter
 * @Description
 * @Author qsf
 * Date   2022-02-18  22:28
 */
public class FindCenter {

    public int findCenter(int[][] edges) {
        return (edges[1][0] == edges[0][0]) || (edges[1][0] == edges[0][1]) ? edges[1][0] : edges[1][1];
    }

    public static void main(String[] args) {
        FindCenter findCenter = new FindCenter();
        System.out.println(2 == findCenter.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
        System.out.println(1 == findCenter.findCenter(new int[][]{{1,2},{5,1},{1,3},{1,4}}));
    }
}
