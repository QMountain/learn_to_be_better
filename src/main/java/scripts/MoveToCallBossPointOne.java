package scripts;

import javafx.animation.TranslateTransition;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class MoveToCallBossPointOne {

    public static void move(Robot robot, Random random) {
        walkToPlace(robot, random);
    }

    public static void walkToPlace(Robot robot, Random random) {
        // 1. 出生点传送
        //      1.1 按出游戏内地图
        robot.delay(Math.abs(random.nextInt()) % 300);
        robot.keyPress(192);
        robot.keyRelease(192);
        //      1.2 鼠标选中传送点
        robot.delay(Math.abs(random.nextInt()) % 300);
        robot.mouseMove(295, 515);
        //      1.3 鼠标点击
        robot.delay(Math.abs(random.nextInt()) % 300);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //      1.4 弹出确认框后，移动鼠标到确认按钮
        robot.delay(Math.abs(random.nextInt()) % 500);
        robot.mouseMove(350, 400);
        //      1.5 鼠标点击 确认 按钮
        robot.delay(Math.abs(random.nextInt()) % 1000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //      1.6 等传送完成，画面变化，关闭地图
        robot.delay(1000);
        robot.keyPress(192);
        robot.keyRelease(192);
        // 2. 移动到左下角Boss召唤点
        //      2.1 向左走
        robot.delay(Math.abs(random.nextInt()) % 300);
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(3500);
        robot.keyRelease(KeyEvent.VK_A);

        //      2.2 向前走
        robot.delay(Math.abs(random.nextInt()) % 300);
        robot.keyPress(KeyEvent.VK_W);
        robot.delay(4200);
        robot.keyRelease(KeyEvent.VK_W);

        //      2.3 向左走
        robot.delay(Math.abs(random.nextInt()) % 300);
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(11000);
        robot.keyRelease(KeyEvent.VK_A);
        //      2.4 向后走
        robot.delay(Math.abs(random.nextInt()) % 300);
        robot.keyPress(KeyEvent.VK_S);
        robot.delay(1600);
        robot.keyRelease(KeyEvent.VK_S);
        //      2.5 向左走
        robot.delay(Math.abs(random.nextInt()) % 300);
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(1000);
        robot.keyRelease(KeyEvent.VK_A);
        //      2.6 向前走
        robot.delay(Math.abs(random.nextInt()) % 300);
        robot.keyPress(KeyEvent.VK_W);
        robot.delay(1300);
        robot.keyRelease(KeyEvent.VK_W);
        //      2.7 转头
        robot.delay(Math.abs(random.nextInt()) % 800);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        System.out.println(screenSize);
        toolkit.setDynamicLayout(true);

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setToX(800);

        robot.mouseMove(1200, 515);
        robot.delay(Math.abs(random.nextInt()) % 2000);
    }
}
