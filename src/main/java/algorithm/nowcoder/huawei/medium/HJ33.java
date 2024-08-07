package algorithm.nowcoder.huawei.medium;

import java.util.Scanner;

// HJ33 整数与IP地址间的转换
public class HJ33 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.next();
        long ip2 = in.nextLong();
        String[] split = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            int i = Integer.parseInt(s);
            String binaryString = Integer.toBinaryString(i);
            for (int j = 0; j < 8 - binaryString.length(); j++) {
                sb.append("0");
            }
            sb.append(binaryString);
        }
        long l = Long.parseLong(sb.toString(), 2);
        System.out.println(l);
        String binaryString = Long.toBinaryString(ip2);
        StringBuilder sb2 = new StringBuilder();
        for (int i = binaryString.length() - 8; i > -8; i-=8) {
            String substring = binaryString.substring(Math.max(0, i), i + 8);
            int i1 = Integer.parseInt(substring, 2);
            sb2.insert(0, i1);
            sb2.insert(0, ".");
        }
        System.out.println(sb2.substring(1));
    }
}
