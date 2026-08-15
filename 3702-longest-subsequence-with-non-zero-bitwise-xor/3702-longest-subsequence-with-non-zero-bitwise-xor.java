class Solution {
    public int longestSubsequence(int[] nums) {
        //xor -> 0 xor 0=0
        // 1 xor 1=0
        // 1 xor 0 or 0 xor 1=1
        int n=nums.length;
        int xor=0;
        boolean allzero=true;

        for(int i=0;i<n;i++){
            xor^=nums[i];
            if(nums[i]!=0) allzero=false;
        }

        if(xor!=0){
            return n;
        }

        if(allzero) return 0;

        int[] dp=new int[n];
        Arrays.fill(dp, -1);

        return DP(nums, dp, 0, 0);
    }

    public int DP(int[] nums, int[] dp, int ind, int xor){
        if(ind==nums.length){
            return xor != 0 ? 0 : Integer.MIN_VALUE;
        }

        if(dp[ind]!=-1) return dp[ind];

        int pick=1+DP(nums, dp, ind+1, xor^nums[ind]);

        int notpick=DP(nums, dp, ind+1, xor);

        return dp[ind]=Math.max(0, Math.max(pick, notpick));
    }
}