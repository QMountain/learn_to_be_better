package javase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test {

    // 计算String乘法
    public String multi(String s1, String s2) {
        int length = s2.length();
        String res = "0";
        for (int i = length-1; i >= 0; i--) {
            char c = s2.charAt(i);
            StringBuilder sb = multiSingle(s1, c);
            if (!sb.toString().startsWith("0")) {
                for (int j = 0; j < length - 1 - i; j++) {
                    sb.append("0");
                }
            }
            res = add(res,sb.toString());
        }
        return res;
    }

    public StringBuilder multiSingle(String s, char c) {
        if (c == '0') {
            return new StringBuilder("0");
        }
        int carry = 0;
        int num2 = Integer.parseInt(c + "");
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = length-1; i >= 0; i--) {
            int num1 = Integer.parseInt(s.charAt(i) + "");
            int cal = num1*num2+carry;
            carry = cal / 10;
            sb.insert(0,cal % 10);
        }
        if (carry != 0) {
            sb.insert(0,carry);
        }
        return sb;
    }

    // 计算String 加法
    public String add(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int carry = 0;
        int index1 = length1-1;
        int index2 = length2-1;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            int num1 = 0;
            if (index1 >= 0) {
                num1 = Integer.parseInt(s1.charAt(index1) + "");
            }
            int num2 = 0;
            if (index2 >= 0) {
                num2 = Integer.parseInt(s2.charAt(index2) + "");
            }
            int cal = num1+num2+carry;
            carry = cal / 10;
            sb.insert(0,cal%10);
            index1--;
            index2--;
        }
        if (carry != 0) {
            sb.insert(0,carry);
        }
        return sb.toString();
    }

    // 计算 1024!
    public String cal() throws Exception {
        List<Callable<String>> callableList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            callableList.add(() -> {
                String res = String.valueOf(finalI *100-99);
                for (int j = finalI *100-98; j <= finalI *100; j++) {
                    res = multi(res,String.valueOf(j));
                }
                System.out.println("cal "+(finalI *100-98)+" - "+ (finalI *100)+", res="+res);
                return res;
            });
        }
        callableList.add(() -> {
            String res = String.valueOf(1001);
            for (int j = 1002; j <= 1024; j++) {
                res = multi(res,String.valueOf(j));
            }
            System.out.println("cal 1001-1024, res="+res);
            return res;
        });
        ThreadPoolExecutor executor = new ThreadPoolExecutor(11, 11, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        List<Future<String>> futureList = executor.invokeAll(callableList);
        String s = futureList.get(0).get();
        for (int i = 1; i < futureList.size(); i++) {
            Future<String> future = futureList.get(i);
            String cs = future.get();
            s = multi(s,cs);
        }
        executor.shutdown();
        return s;
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        //System.out.println(test.multi("9140278528434955648419686651689052069378745575014013113741319272836748101550080000000000000000000", "905285344846560387492881197293380626937747268250265542646570491696848509228806283878780108800000000000000000000"));
        String cal = test.cal();
        int count = 0;
        for (int i = cal.length()-1; i > 0; i--) {
            if (cal.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        System.out.println("末尾："+count);
        System.out.println(cal);
    }
}