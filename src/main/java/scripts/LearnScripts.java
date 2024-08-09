package scripts;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class LearnScripts {

    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        Random random = new Random();
        Robot robot = new Robot();
        // 1. 唤醒CF窗口
        robot.mouseMove(400,480);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        // 2. 点击开始游戏
        robot.mouseMove(750,480);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        // 3. 等待15秒加载游戏
        robot.delay(15_000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        // 4. 按 K 出地图
        robot.keyPress(KeyEvent.VK_K);
        robot.keyRelease(KeyEvent.VK_K);
        // 5. 点击选择完毕
        robot.delay(Math.abs(random.nextInt()) % 300);
        robot.mouseMove(360,485);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        // 6. 等待25秒动画
        robot.delay(25_000);
        // 7. 向前走
        robot.keyPress(KeyEvent.VK_W);
        robot.delay(1000);
        robot.keyRelease(KeyEvent.VK_W);
        robot.delay(Math.abs(random.nextInt()) % 300);
        // 8. 向左走
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(5000);
        robot.keyRelease(KeyEvent.VK_A);
        robot.mouseMove(200,485);
        // 7. 按出游戏内地图
        robot.keyPress(192);
        robot.keyRelease(192);

        /*robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/
        //robot.mouseMove(400,600);
        /*
        for (int i = 0; i < 10; i++) {
            //TimeUnit.SECONDS.sleep(1L);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_W);
        }*/

    }

}
