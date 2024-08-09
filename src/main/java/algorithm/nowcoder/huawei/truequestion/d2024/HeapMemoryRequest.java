package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 堆内存申请
public class HeapMemoryRequest {

    static class Memory {
        // 内存块起始位置
        int offset;
        // 内存块大小
        int size;

        public Memory(int offset, int size) {
            this.offset = offset;
            this.size = size;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 要申请的内存大小
        int malloc_size = Integer.parseInt(sc.nextLine());

        // 已占用的内存
        ArrayList<Memory> used_memory = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // 本地测试使用空行作为结束条件
            //      if (line.length() == 0) break;

            int[] tmp = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            used_memory.add(new Memory(tmp[0], tmp[1]));
        }

        System.out.println(getResult(malloc_size, used_memory));
    }

    public static int getResult(int malloc_size, ArrayList<Memory> used_memory) {
        // 申请的内存大小非法，则返回-1
        if (malloc_size <= 0 || malloc_size > 100) {
            return -1;
        }

        // 记录最优的申请内存起始位置
        int malloc_offset = -1;
        // 记录最接近申请内存的空闲内存块大小
        int min_malloc_size = 100;

        // 对占用的内存按照起始位置升序
        used_memory.sort((a, b) -> a.offset - b.offset);

        // 记录（相对于已占用内存的前面一个）空闲内存块的起始位置
        int free_offset = 0;

        for (Memory used : used_memory) {
            // 如果占用的内存起始位置 小于 前面一个空闲内存块起始位置，则存在占用内存区域重叠
            // 如果占用的内存起始位置 大于 99，则非法
            if (used.offset < free_offset || used.offset > 99) return -1;

            // 如果占用的内存的大小少于0，则非法
            // 如果占用的内存的大小超过该内存起始位置往后所能申请到的最大内存大小，则无效
            if (used.size <= 0 || used.size > 100 - used.offset) return -1;

            // 空闲内存块地址范围是：free_offset ~ memory.offset - 1
            if (used.offset > free_offset) {
                // 空闲内存块大小
                int free_memory_size = used.offset - free_offset;

                // 如果该空闲内存块大小足够，且最接近申请的内存大小
                if (free_memory_size >= malloc_size && free_memory_size < min_malloc_size) {
                    malloc_offset = free_offset;
                    min_malloc_size = free_memory_size;
                }
            }

            // 更新：空闲内存的起始位置 = （当前占用内存的结束位置 + 1） = （当前占用内存的起始位置 + 占用大小）
            free_offset = used.offset + used.size;
        }

        // 收尾
        int last_free_memory_size = 100 - free_offset;
        if (last_free_memory_size >= malloc_size && last_free_memory_size < min_malloc_size) {
            malloc_offset = free_offset;
        }

        return malloc_offset;
    }

}
