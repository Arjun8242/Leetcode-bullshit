class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] count=new int[31];
        long[] arr=new long[k];
        int MOD=1000000007;

        for(int x:nums){
            for(int bit=0;bit<31;bit++){
                if((x & (1<<bit))!=0){
                    count[bit]++;
                }
            }
        }

        for(int bit=0;bit<31;bit++){
            for(int i=0;i<Math.min(count[bit], k);i++){
                arr[i]=arr[i] | (1<<bit);
            }
        }

        long ans=0;

        for(long num:arr){
            ans=(ans+num*num)%MOD;
        }

        return (int)ans;
    }
}