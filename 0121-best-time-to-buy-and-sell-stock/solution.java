class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices.length < 2) return res;

        int l = 0;
        int r = 1;
        while(r < prices.length){
            if(l < r && prices[l] > prices[r]){
                l = r;
                r++;
                continue;
            }
            res = Math.max(prices[r] - prices[l], res);
            r++;
        }

        return res;
    }
}

