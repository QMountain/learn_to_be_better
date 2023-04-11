package algorithm.leetcode.medium.i;

public class IsRobotBounded {

    public boolean isRobotBounded(String instructions) {
        int[] position = new int[]{0,0};
        String towards = "up";
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'G') {
                switch (towards) {
                    case "up":
                        position[1]++;
                        break;
                    case "down":
                        position[1]--;
                        break;
                    case "left":
                        position[0]--;
                        break;
                    default:
                        position[0]++;
                        break;
                }
            } else {
                if (c == 'L') {
                    switch (towards) {
                        case "up":
                            towards = "left";
                            break;
                        case "down":
                            towards = "right";
                            break;
                        case "left":
                            towards = "down";
                            break;
                        default:
                            towards = "up";
                            break;
                    }
                } else {
                    switch (towards) {
                        case "up":
                            towards = "right";
                            break;
                        case "down":
                            towards = "left";
                            break;
                        case "left":
                            towards = "up";
                            break;
                        default:
                            towards = "down";
                            break;
                    }
                }
            }
        }
        if (position[0] == 0 && position[1] == 0) {
            return true;
        }
        return !towards.equals("up");
    }

    public static void main(String[] args) {
        IsRobotBounded isRobotBounded = new IsRobotBounded();
        System.out.println(isRobotBounded.isRobotBounded("RGL"));
        System.out.println(isRobotBounded.isRobotBounded("RRGRRGLLLRLGGLGLLGRLRLGLRLRRGLGGLLRRRLRLRLLGRGLGRRRGRLG"));
        System.out.println(isRobotBounded.isRobotBounded("RLLGGLRGLGLLLGRLRLRLRRRRLRLGRLLLGGL"));
        System.out.println(isRobotBounded.isRobotBounded("RGGGLGLLLLGLRGRLGGRLLRRRL"));
        System.out.println(isRobotBounded.isRobotBounded("GLGLGGLGL"));
        System.out.println(isRobotBounded.isRobotBounded("LLGRL"));
        System.out.println(isRobotBounded.isRobotBounded("GL"));
        System.out.println(isRobotBounded.isRobotBounded("GG"));
        System.out.println(isRobotBounded.isRobotBounded("GGLLGG"));
    }
}
