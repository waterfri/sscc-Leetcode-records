// #122 买卖股票的最佳时机 II
// 算法思想：每天尝试盈利
int maxProfit(int* prices, int pricesSize) {
    int Maxprofit = 0; //总利润
    int profit = 0; // 每次买卖的利润
    int minP = prices[0]; // 第一天价格作为最小价格买入
    // 从第二天开始尝试盈利
    for(int i=1;i<pricesSize;i++){
        // 如果明日能盈利，则明日卖出，随时间进行更新最小价格
        if(prices[i]>minP){
            profit = prices[i] - minP;       
            Maxprofit = profit + Maxprofit;
            minP = prices[i];
        }
        // 如果明日不能盈利，今日卖出，明日买入
        if(prices[i]<minP){
            minP = prices[i];
        }
}
   return Maxprofit;
}