// 滴滴 1. 方块世界
// 差分数组
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class solution{
    public int Solution(int x){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); // 下雨次数
    
        int[] a = new int[n]; // 方块堆数组
    
        Map<Integer, Integer> map = new HashMap<>();

        while(m > 0){
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1; 
            int amount = sc.nextInt();
    
            for(int j = l; j < r + 1; j++){
                a[j]+= amount;
            }
    
            m--;
        }
        
        int h = 1;
        while(h < 1000001){
            int result = 0;
            for(int i = 0; i < n; i++){
                if(a[i] >= h){
                    result++;
                }
            }
            h++;
            map.put(result, 1);
        }

        return map.size();
    }
}