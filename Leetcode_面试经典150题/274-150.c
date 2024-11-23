// #274 H指数
// 考察 H指数的定义
// 算法思路：先降序排序，元素与下标相等时，下标+1即 H指数
// 排序算法

int hIndex(int* citations, int citationsSize) {
    int count = 0; // 满足条件的篇数
    // 形成降序数组
    for(int i=0;i<citationsSize; i++){
        for(int j=i+1; j<citationsSize; j++){
            if(citations[j]>citations[i]){
                int t = citations[i];
                citations[i] = citations[j];
                citations[j] = t;
            }
        }
    }
    for(int i=0; i<citationsSize; i++){
        if(citations[i] < i + 1){
            break;
        }
        else{
            count++;
        }
    }
    return count;
}