// 1. 尾巴大人

import java.util.Scanner;

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 1;

        if(n == 0){
            sum = 1;
            System.out.println(sum);
        }

        while(n > 0){
            sum = sum * n;
            n--;
        }

        int result = sum % 10;

        System.out.println(result);

    }
}