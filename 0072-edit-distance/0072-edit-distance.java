class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        char[] w1=word1.toCharArray();
        char[] w2=word2.toCharArray();
        int[][] dp=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        return solve(w1, w2, dp, n-1, m-1);
    }

    public int solve(char[] w1, char[] w2, int[][] dp, int i, int j){
        if(i<0){
            return j-i;
        }
        if(j<0){
            return i-j;
        }

        if(i<0 && j<0){
            return 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        if(w1[i]==w2[j]) return solve(w1, w2, dp, i-1, j-1);

        return dp[i][j]=1+Math.min(solve(w1, w2, dp, i-1, j-1), Math.min(solve(w1, w2, dp, i-1, j), solve(w1, w2, dp, i, j-1)));
    }
}