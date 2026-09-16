class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n][3];

        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        return solve(0, 0, prices);
    }

    public int solve(int ind, int state, int[] prices){
        if(ind>=prices.length) return 0;

        if(dp[ind][state]!=-1) return dp[ind][state];

        if(state==0){
            int buy=-prices[ind]+solve(ind+1, 1, prices);

            int skip=solve(ind+1, 0, prices);

            dp[ind][state]=Math.max(buy, skip);
        }

        else if(state==1){
            int sell=prices[ind]+solve(ind+1, 2, prices);

            int skip=solve(ind+1, 1, prices);

            dp[ind][state]=Math.max(sell, skip);
        }

        else{
            dp[ind][state]=solve(ind+1, 0, prices);
        }

        return dp[ind][state];
    }
}