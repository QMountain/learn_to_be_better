package algorithm.leetcode.medium.e;

public class EdgeScore {

    public int edgeScore(int[] edges) {
        int length = edges.length;
        long[] count = new long[length];
        for (int i = 0; i < length; i++) {
            count[edges[i]] += i;
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EdgeScore edgeScore = new EdgeScore();
        System.out.println(7 == edgeScore.edgeScore(new int[]{1,0,0,0,0,7,7,5}));
    }
}
