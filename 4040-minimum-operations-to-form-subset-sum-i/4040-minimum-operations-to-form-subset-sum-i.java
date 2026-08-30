class Solution {
    public int minOperations(int[] nums, int sum) {
        int n=nums.length;
        int[][] dp=new int[n+1][sum+1];
        for(int[] row:dp)Arrays.fill(row, Integer.MAX_VALUE);

        dp[0][0]=0;

        for(int i=0;i<n;i++){
            List<int[]> possible=generate(nums[i], sum);

            for(int s=0;s<=sum;s++){
                if(dp[i][s]==Integer.MAX_VALUE) continue;

                //don't pick
                dp[i+1][s]=Math.min(dp[i+1][s], dp[i][s]);

                //pick
                for(int[] 
                p:possible){
                    int val=p[0];
                    int ops=p[1];

                    if(s+val<=sum){
                        dp[i+1][s+val]=Math.min(dp[i+1][s+val], dp[i][s]+ops);
                    }
                }
            }
        }

        return dp[n][sum] == Integer.MAX_VALUE ? -1 : dp[n][sum];
    }
    public List<int[]> generate(int num, int sum){
        int multiply=0;
        List<int[]> list=new ArrayList<>();
        int val=num;

        while(true){
            int x=val;
            int divide=0;
            while(x>0){
                list.add(new int[]{x, multiply+divide});

                x/=2;
                divide++;
            }

            if(val>sum)break;

            val*=2;
            multiply++;
        }
        return list;
    }
}