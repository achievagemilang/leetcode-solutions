class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        int sum = 0;
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return f(0, n - 1, piles, dp) > 0;
    }

    public int f(int start, int end, int[] piles, int[][] dp){
        if(start > end){
            return 0;
        }
        if(dp[start][end] != -1) return dp[start][end];

        int takeLeft = piles[start] - f(start+1, end, piles, dp);
        int takeRight = piles[end] - f(start, end-1, piles, dp);


        dp[start][end] = Math.max(takeLeft, takeRight);
        return dp[start][end];
    } 
}
