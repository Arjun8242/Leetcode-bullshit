class Solution {
    int m,n;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        m=grid.length;
        n=grid[0].length;

        dp=new Boolean[m][n][m+n];

        return dfs(0, 0, 0, grid);
    }

    public boolean dfs(int i, int j, int totalbrackets, char[][] grid){
        if(i>=m || j>=n) return false;

        if(grid[i][j]=='('){
            totalbrackets++;
        }
        else{
            totalbrackets--;
        }

        if(totalbrackets<0) return false;


        //yaha 3 states chahiye 1.not calculated 2.calculated -> true 3.calculated -> false
        if(dp[i][j][totalbrackets]!=null){
            return dp[i][j][totalbrackets];
        }

        if(i==m-1 && j==n-1){
            return totalbrackets==0;
        }

        return dp[i][j][totalbrackets]=dfs(i+1, j, totalbrackets, grid) || dfs(i, j+1, totalbrackets, grid);
    }
}

//at any point ')' shouldn't be more than '(' acc to ques