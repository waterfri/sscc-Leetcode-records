// 滴滴 2. 两个零件
// 没做完
import java.util.Scanner;

class Solution{
    public int Solution(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];

        int i = 0;

        while(i < n){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            i++;
        }

        int aa[] = new int[n];
        int bb[] = new int[n];

        for(int j = 0; j < n; j++){
            if(a[j] < b[j]){
                int aa[j] = a[j];
                int bb[j] = b[j]-k;
            }
        }
    }
}