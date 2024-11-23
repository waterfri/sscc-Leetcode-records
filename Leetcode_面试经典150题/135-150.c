// #135 分发糖果
// 算法思路：保证每个元素单侧的更高分获得 +1 糖果，左右两侧拆解为 左侧+右侧，使用二次相向遍历
// 注意：需要初始化每个元素的初值

int candy(int* ratings, int ratingsSize) {
    int* candies = (int*)malloc(sizeof(int) * ratingsSize);

    // 每个孩子至少一个糖果
    for(int i=0; i<ratingsSize; i++){
        candies[i] = 1;
    } 
    // 从左向右遍历
    for(int i=1; i<ratingsSize; i++){
        if(ratings[i] > ratings[i-1]){
            candies[i] = candies[i-1] + 1;
        }
    }
    // 从右向左遍历
    for(int i=ratingsSize-1; i>=1; i--){
        if(ratings[i-1] > ratings[i]){
            if(candies[i-1] <= candies[i]){ // 如果左边糖果比右边少
                candies[i-1] = candies[i] + 1;
            }
        }
    }

    int total = 0; // 需要的最少糖果
    for(int i=0; i<ratingsSize; i++){
        total = total + candies[i];
    }
    free(candies);
    return total;
}