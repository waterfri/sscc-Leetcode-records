// #56 合并区间
// 数组
// 区间
// 排序
// 算法思想：先排序，然后遍历每个区间判断是否能合并
import java.util.Arrays;
import java.util.LinkedList;
class Solution {
    public int[][] merge(int[][] intervals) {
        // 按区间起始值排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // 使用 lambda表达式作为 comparator参数进行升序排序

        // 使用 LinkedList存储结果
        LinkedList<int[]> result = new LinkedList<>();

        // 遍历每个区间
        for(int[] interval : intervals){
            // 第一个区间加入结果
            // 当前区间与 result最后一个区间不重叠时，直接将该区间加入 result
            if(result.isEmpty() || result.getLast()[1] < interval[0]){
                result.add(interval);
            }
            // 否则与 result最后一个区间合并
            else{
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        // 结果转换为二维数组返回
        return result.toArray(new int[result.size()][]);

    }
}
// // Arrays.sort() 是 Java 中的一个静态方法，用于对数组进行排序。当我们提供一个 Comparator 参数 时，sort 函数会根据 Comparator 中定义的比较规则，逐一比较数组中的元素，并确定它们的排序顺序。

// 1. sort() 方法的工作机制

// a. 内部原理
// 	•	排序算法：Arrays.sort() 的底层实现根据数组的类型和大小不同，会选择不同的排序算法：
// 	•	Dual-Pivot QuickSort：用于对基本类型数组（如 int[]、double[]）排序。
// 	•	TimSort：用于对象数组排序。TimSort 是一种优化后的归并排序，特别适合具有部分有序性的数组。
// 	•	比较逻辑：当你传入 Comparator 参数时：
// 	•	Arrays.sort() 会通过调用 compare(T o1, T o2) 方法，确定两个元素的相对顺序。
// 	•	具体逻辑如下：
// 	•	如果 compare(o1, o2) < 0，则 o1 排在 o2 之前。
// 	•	如果 compare(o1, o2) == 0，则 o1 和 o2 的相对位置保持不变（稳定排序）。
// 	•	如果 compare(o1, o2) > 0，则 o2 排在 o1 之前。

// b. 通过 Comparator 决定排序依据

// Comparator 告诉 sort() 方法如何比较数组中的两个元素。例如：
// 	•	按某个字段排序
// 	•	按多个字段排序
// 	•	按自定义规则排序

// Arrays.sort() 会多次调用 compare() 方法来比较数组中的元素，并根据返回值调整元素的位置，直到整个数组有序。

// 2. 示例：如何根据 Comparator 排序

// 假设我们有一个二维数组，每个元素是一个区间 [start, end]，我们希望按 start 升序排序：

// 代码示例

// int[][] intervals = {{5, 10}, {1, 3}, {8, 12}};

// // 使用 Comparator 进行排序
// Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

// 排序过程
// 	1.	Arrays.sort() 从数组中取出两个元素（如 {5, 10} 和 {1, 3}）。
// 	2.	调用 Comparator 中的比较方法：
// 	•	a[0] = 5, b[0] = 1
// 	•	Integer.compare(a[0], b[0]) 返回 1（即 5 > 1），因此 {1, 3} 应该排在 {5, 10} 之前。
// 	3.	根据比较结果调整元素的位置。
// 	4.	重复步骤 1 和 2，直到数组整体有序。

// 最终排序结果为：{{1, 3}, {5, 10}, {8, 12}}

// 3. 如何影响排序依据

// 通过 Comparator 定义的逻辑直接决定排序依据。例如：

// a. 单字段排序

// Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // 按 start 排序

// b. 多字段排序

// Arrays.sort(intervals, (a, b) -> {
//     if (a[0] != b[0]) {
//         return Integer.compare(a[0], b[0]); // 先按 start 排序
//     } else {
//         return Integer.compare(a[1], b[1]); // 再按 end 排序
//     }
// });

// c. 倒序排序

// Arrays.sort(intervals, (a, b) -> Integer.compare(b[0], a[0])); // 按 start 倒序

// 4. 为什么 sort 能根据 Comparator 确定排序

// a. Comparator 的定义

// Comparator 本质上是一个函数，Arrays.sort() 通过调用它来比较两个元素，进而确定它们的顺序。你提供的比较逻辑告诉 sort：
// 	•	什么是“更小”的元素（排在前面）。
// 	•	什么是“更大”的元素（排在后面）。

// b. 基于比较结果调整顺序
// 	•	Arrays.sort() 调用 Comparator.compare() 的结果指导排序过程。例如：
// 	•	如果 compare(a, b) 返回负数，表示 a 小于 b，保持原有顺序。
// 	•	如果 compare(a, b) 返回正数，表示 b 小于 a，交换这两个元素的位置。

// c. 重复调用比较

// 排序算法会不断调用 compare() 方法，直到整个数组达到有序状态。TimSort 使用了一种分治策略，通过多次比较、交换，逐步完成排序。

// 5. 总结
// 	•	Arrays.sort() 的排序依据完全由 Comparator 定义。
// 	•	Comparator 的核心是 compare(T o1, T o2) 方法，它定义了两个元素的比较逻辑。
// 	•	sort() 内部通过调用 compare() 方法确定元素的顺序，并根据排序算法（如 TimSort）调整元素的位置。