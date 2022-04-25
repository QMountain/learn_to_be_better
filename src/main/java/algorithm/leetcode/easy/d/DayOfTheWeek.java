package algorithm.leetcode.easy.d;

/**
 * @ClassName DayOfTheWeek
 * @Description
 * @Author qsf
 * Date   2022-01-19  23:29
 */
public class DayOfTheWeek {

    public String dayOfTheWeek(int day, int month, int year) {
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        // based on 1971-1-1  星期五  1970-12-31 星期四
        int days = (year - 1971) * 365 + (year - 1969)/4;
        for (int i = 0; i < month - 1; i++) {
            days += months[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days++;
        }
        days += day;
        return weeks[(days+3)%7];
    }

    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        System.out.println(dayOfTheWeek.dayOfTheWeek(31, 8, 2019));
        System.out.println(dayOfTheWeek.dayOfTheWeek(29, 2, 2000));
    }
}
