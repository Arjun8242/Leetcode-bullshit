class Solution {
    int ways;
    int[][] dp;
    int MOD=1000000007;
    public int numWays(int steps, int arrLen) {

        int n=Math.min(arrLen, steps / 2 + 1);
        dp=new int[n][steps+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=steps;j++){
                dp[i][j]=-1;
            }
        }
        solve(0, steps, n);

        return dp[0][steps];
    }
    public int solve(int ind, int steps, int n){
        if(ind<0 || ind>n-1) return 0;

        if(dp[ind][steps]!=-1) return dp[ind][steps];

        if(steps==0){
            if(ind==0) return 1;
            else return 0;
        }

        int left=solve(ind-1, steps-1, n);
        int right=solve(ind+1, steps-1, n);
        int stay=solve(ind, steps-1, n);

        dp[ind][steps] = (int)(((long)left + right + stay) % MOD);

        return dp[ind][steps];

    }

}