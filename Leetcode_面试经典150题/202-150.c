// #202 快乐数
// 哈希表 
// 动态分配数组
// 双指针 
// 快慢指针
// 整除 
// 取模

// 哈希表算法
#include <stdbool.h>

int getNextNumber(int n){
    int sum = 0;
    while(n > 0){
        int d = n % 10; // 取模运算 取余数
        sum += d * d;
        n = n / 10; // 整除，去掉个位数字
    }
    return sum;
}

bool isHappy(int n) {
    // 数字 n 的每位平方和有一个上界，如果结果重复出现，则会进入循环
    // 所以我们可以使用哈希表记录出现过的结果
    int* seen = malloc(1024 * sizeof(int)); 
    // 32 位整数范围内（即  n \leq 2^{31} - 1 ），数字平方和的最大可能值出现在 999999999，其平方和为：9^2 \times 9 = 729
    int seensize = 0;
    while(n != 1){
        // 检查结果是否出现过
        for(int i = 0; i < seensize; i++){
            if(seen[i] == n){
                return false;
            }
        }
        seen[seensize++] = n; // 计入哈希表
        n = getNextNumber(n);
    }
    return true;
}

// 快慢指针算法