package practice3.bestTimeToSellBuy;

public class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int min = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(min > prices[i]) {
                min = prices[i];
            } else {
                profit = Math.max(prices[i] - min, profit);
            }
        }

        answer = profit;
        return answer;
    }
}
