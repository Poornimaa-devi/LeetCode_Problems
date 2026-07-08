1class Solution {
2    public int maxProfit(int[] prices) {
3        int minprice = prices[0];
4        int maxprofit=0;
5        for(int i=0;i<prices.length;i++){
6            int profit = prices[i]-minprice;
7            if(profit>maxprofit) maxprofit=profit;
8            if(prices[i]<minprice) minprice = prices[i];
9        }
10        return maxprofit;
11    }
12}