// #121 买卖股票最佳时机
int maxProfit(int* prices, int pricesSize) {
    if(pricesSize == 0) {
        return 0;
    }
    int minPrice = prices[0];
    int maxProfit = 0;
    for(int i=0;i<pricesSize;i++){
        if(prices[i]<minPrice){
            minPrice = prices[i];
        }
        if(prices[i] - minPrice > maxProfit){
            maxProfit = prices[i] - minPrice;
        }
    }
    return maxProfit;
}