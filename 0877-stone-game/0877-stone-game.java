class Solution {
    Integer[][] dp;

    public boolean stoneGame(int[] nums) {
        int n=nums.length;
        dp=new Integer[n][n];
        return solve(0, nums.length-1, nums)>=0;
    }

    public int solve(int left, int right, int[] nums){

        if(left==right) return nums[left];

        if (dp[left][right] != null)
            return dp[left][right];
            
        int pickleft=nums[left]-solve(left+1, right, nums);

        int pickright=nums[right]-solve(left, right-1, nums);

        return dp[left][right] = Math.max(pickleft, pickright);
    }
}