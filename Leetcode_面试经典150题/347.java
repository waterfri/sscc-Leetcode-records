// #347 Top K Frequent
// PriorityQueue
// List 普通排序
// 小根堆
// 桶排序
// 思路：
//

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution{
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();

        // 统计频率
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // 小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int e : map.keySet()){
            // 堆没满 入堆
            if(pq.size() < k){
                pq.offer(e);
            }
            // 堆满 替换
            else if(map.get(e) > map.get(pq.peek())){ // 比较 频率
                pq.poll();
                pq.offer(e);
            }
        }

        int[] result = new int[pq.size()];

        int i = 0;
        while(!pq.isEmpty()){
            result[i++] = pq.poll();
        }

        return result;
    }
}