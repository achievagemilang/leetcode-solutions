class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
    
        int res = f(0, dp, stoneValue);

        if(res > 0) return "Alice";
        if(res < 0) return "Bob";
        return "Tie";
    }

    public int f(int start, int[] dp, int[] stoneValue){
        if(start >= stoneValue.length) return 0;
        if(dp[start] != Integer.MIN_VALUE) return dp[start];

        int takeTwo = Integer.MIN_VALUE, takeThree = Integer.MIN_VALUE;
        int takeOne = stoneValue[start] - f(start+1, dp, stoneValue);
        if (start + 1 < stoneValue.length){
            takeTwo = stoneValue[start] + stoneValue[start+1] - f(start+2, dp, stoneValue);
        }
        if (start + 2 < stoneValue.length){
            takeThree = stoneValue[start] + stoneValue[start+1] + stoneValue[start+2] - f(start+3, dp, stoneValue);
        }

        dp[start] = Math.max(takeOne, Math.max(takeTwo, takeThree));
        return dp[start];
    }
}


