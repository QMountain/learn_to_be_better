package algorithm.leetcode.medium.f;

public class FlipLights {

    public int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            if (presses == 1) {
                return 3;
            }
            return 4;
        }
        // n >= 3
        if (presses == 1) {
            return 4;
        }
        if (presses == 2) {
            return 7;
        }
        if (presses <= 4) {
            return 8;
        }
        return flipLights(n,4);
    }

    public static void main(String[] args) {
        FlipLights flipLights = new FlipLights();
        System.out.println(8 == flipLights.flipLights(4, 4));
        System.out.println(8 == flipLights.flipLights(3, 5));
        System.out.println(7 == flipLights.flipLights(3, 2));
        System.out.println(8 == flipLights.flipLights(3, 3));
        System.out.println(2 == flipLights.flipLights(1, 1));
        System.out.println(3 == flipLights.flipLights(2, 1));
        System.out.println(4 == flipLights.flipLights(3, 1));
    }
}
