// #134. 加油站
// 解题思路：计算总获得油量与总消耗油量之差，如果该值 >=0，则说明一定能找到某个出发点，完成环行一周
// 
int canCompleteCircuit(int* gas, int gasSize, int* cost, int costSize) {
    int start = 0; // 出发点
    int total = 0; // 总油量与总耗油量之差
    int oil = 0; // 当前油量
    // 循环遍历所有站点
    for(int i=0; i<gasSize; i++){
        oil = oil + gas[i] - cost[i]; // 更新油量
        total = total + gas[i] - cost[i];

        if(oil < 0){ // 不能从该站点出发
            start = i + 1; // 尝试下一个站点
            oil = 0; // 重置油量
        }
    }
    return total>=0 ? start : -1;
}