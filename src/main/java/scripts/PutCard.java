package scripts;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class PutCard {

    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        Random random = new Random();
        while (true) {
            while (robot.getPixelColor(600, 480).getRGB() != -13945273) {
                // 按E
                robot.delay(Math.abs(random.nextInt()) % 500);
                robot.keyPress(KeyEvent.VK_E);
                robot.keyRelease(KeyEvent.VK_E);
                robot.delay(Math.abs(random.nextInt()) % 500);
            }
            // 选卡
            robot.delay(Math.abs(random.nextInt()) % 500);
            robot.mouseMove(220, 330);
            robot.delay(Math.abs(random.nextInt()) % 500);
            robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            // 确认召唤
            robot.delay(Math.abs(random.nextInt()) % 500);
            robot.mouseMove(620, 480);
            robot.delay(Math.abs(random.nextInt()) % 500);
            robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

            // 射击
            robot.delay(Math.abs(random.nextInt()) % 5500);
            robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            while (robot.getPixelColor(430, 85).getRGB() != -1) {
                break;
            }
            robot.delay(1000);
            robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

            robot.delay(Math.abs(random.nextInt()) % 500);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.delay(Math.abs(random.nextInt()) % 500);
        }
    }
}
