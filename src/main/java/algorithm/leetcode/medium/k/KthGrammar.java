package algorithm.leetcode.medium.k;

public class KthGrammar {

    public int kthGrammar(int n, int k) {
        if (k < 2) {
            return 0;
        }
        int i = kthGrammar(n - 1, (k+1) / 2);
        if (k % 2 == 0) {
            return 1-i;
        }
        return i;
    }

    public static void main(String[] args) {
        KthGrammar kthGrammar = new KthGrammar();
        System.out.println(1 == kthGrammar.kthGrammar(3, 3));
        System.out.println(1 == kthGrammar.kthGrammar(2, 2));
        System.out.println(0 == kthGrammar.kthGrammar(2, 1));
        System.out.println(0 == kthGrammar.kthGrammar(1, 1));
    }
}
