package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.ArrayList;
import java.util.Scanner;

// 手机App防沉迷系统
public class MobileAppAntiAddictionSystem {

    static class App {
        String name;
        int priority;
        int startTime;
        int endTime;

        public App(String name, int priority, int startTime, int endTime) {
            this.name = name;
            this.priority = priority;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 需要注册的App
        ArrayList<App> apps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            apps.add(new App(sc.next(), sc.nextInt(), convert(sc.next()), convert(sc.next())));
        }

        // 需要查询的时间点
        int queryTime = convert(sc.next());

        System.out.println(getResult(apps, queryTime));
    }

    public static String getResult(ArrayList<App> apps, int queryTime) {
        // 记录已注册的App
        ArrayList<App> registereds = new ArrayList<>();

        outer:
        for (App app : apps) {
            // 起始时间>=结束时间，则注册不上
            if (app.startTime >= app.endTime) continue;

            // 记录已注册的App中被注销的App的位置
            ArrayList<Integer> idxs = new ArrayList<>();

            // 比较app_registering和它前面完成注册的所有app_registered
            for (int j = 0; j < registereds.size(); j++) {
                App registered = registereds.get(j);

                // 两个App的注册时间无冲突，则继续和下一个app_registered比较
                if (registered.startTime >= app.endTime || app.startTime >= registered.endTime) continue;

                // 两个App的注册时间有冲突，则比较优先级
                if (app.priority > registered.priority) {
                    // 这里不能直接注销低优先级的app_registered，我们要保证app_registering一定能注册后才能进行此操作，因此先记录要被注销的app_registered的位置
                    idxs.add(j);
                } else {
                    // app_registering的优先级 <= app_registered的优先级时，则app_registering不能注册，终止比较
                    continue outer;
                }
            }

            // idxs中索引是升序的，如果正序删除的话，那么每删除一个元素，都会改变后面元素的索引位置，因此这里采用倒序删除
            for (int j = idxs.size() - 1; j >= 0; j--) {
                int deleteIdx = idxs.get(j);
                registereds.remove(deleteIdx);
            }

            registereds.add(app);
        }

        String ans = "NA";

        // 注册成功的App时段之间互不冲突，因此queryTime只会对应一个App
        for (App app : registereds) {
            if (queryTime >= app.startTime && queryTime < app.endTime) {
                ans = app.name;
                break;
            }
        }

        return ans;
    }

    public static int convert(String time) {
        // 时间格式 HH:MM，小时和分钟都是两位，不足两位前面补0
        String[] tmp = time.split(":");

        String hours = tmp[0];
        String minutes = tmp[1];
        return Integer.parseInt(hours) * 60 + Integer.parseInt(minutes);
    }
}
