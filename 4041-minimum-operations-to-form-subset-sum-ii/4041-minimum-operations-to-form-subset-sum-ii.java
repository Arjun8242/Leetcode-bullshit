class Solution {
    public int minOperations(int[] nums, int sum) {
        int[] dp=new int[sum+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int num:nums){
            List<int[]> possibles=generate(num, sum);

            int[] temp=dp.clone();

            for(int i=0;i<=sum;i++){
                if(dp[i]==Integer.MAX_VALUE) continue;

                for(int[] x:possibles){
                    int val=x[0];
                    int ops=x[1];

                    if(i+val<=sum){
                        temp[i+val]=Math.min(temp[i+val], dp[i]+ops);
                    }
                }
            }
            dp=temp;
        }
        return dp[sum]==Integer.MAX_VALUE?-1:dp[sum];
    }

    public List<int[]> generate(int num, int sum){
        
        int divide=0;
        List<int[]> list=new ArrayList<>();

        int x=num;

        while(x>0){
            int curr=x;
            int multiply=0;

            while(curr<=sum){
                
                list.add(new int[]{curr, multiply+divide});

                if(curr>sum/2) break;

                curr*=2;;
                multiply++;
            }

            x/=2;
            divide++;
        }
        return list;
    }
}