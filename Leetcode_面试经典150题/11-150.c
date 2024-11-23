// #11 盛水最多的容器
// 双指针
// 算法思想：双指针从两端出发，每次移动更短柱子的指针，每次更新指针时尝试最大容水量

int maxArea(int* height, int heightSize) {
    int water_max = 0;
    int i = 0;
    int j = heightSize - 1;
    while(i<j){
        int x = j - i;
        int y = height[i] > height[j] ? height[j] : height[i];
        int volume = x * y;
        if(volume > water_max){
            water_max = volume;
        }
        height[i] < height[j] ? i++ : j--; // 移动更矮柱子的指针
    }
    return water_max;
}