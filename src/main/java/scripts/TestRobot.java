package scripts;

import java.awt.*;
import java.util.Random;

public class TestRobot {

    public static void main(String[] args) throws AWTException {
        Random random = new Random();
        Robot robot = new Robot();
        // 召唤boss
        //robot.mouseMove(620, 480);
        // 橙色血条
        int orange = -6536690;
        // 黄色血条
        int yellow = -6520818;
        //int x = 435;·
        //int x = 425;
        /*int x = 430;
        int y = 85;
        robot.mouseMove(x, y);
        Color pixelColor = robot.getPixelColor(x, y);
        int rgb = pixelColor.getRGB();
        System.out.println(pixelColor);
        System.out.println(rgb);*/

        int x = 600;
        int y = 480;
        //robot.mouseMove(x, y);
        while (true) {
            robot.delay(2000);
            Color pixelColor = robot.getPixelColor(x, y);
            int rgb = pixelColor.getRGB();
            System.out.println(pixelColor);
            System.out.println(rgb);
        }

        /*while (true) {
            robot.delay(2000);
            Color pixelColor = robot.getPixelColor(430, y);
            int rgb = pixelColor.getRGB();
            System.out.println(pixelColor);
            System.out.println(rgb);
        }*/
        /*// 1. 唤醒CF窗口
        robot.mouseMove(400,480);`
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        MoveToCallBossPointOne.move(robot, random);*/
        /*// 出生点传送
        robot.mouseMove(295, 515);*/
    }
}
